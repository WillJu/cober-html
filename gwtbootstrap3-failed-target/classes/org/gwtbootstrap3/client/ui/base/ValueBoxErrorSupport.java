package org.gwtbootstrap3.client.ui.base;

/*
/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.List;

import org.gwtbootstrap3.client.ui.HelpBlock;
import org.gwtbootstrap3.client.ui.base.ValueBoxBase.EditorErrorSupport;
import org.gwtbootstrap3.client.ui.constants.ValidationState;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is the default {@link EditorErrorSupport} implementation. The assumption is that every
 * {@link ValueBoxBase} instance will have a {@link HasValidationState} parent. If there is a
 * {@link HelpBlock} that is a child of the {@link HasValidationState} parent then error messages will be
 * displayed in the {@link HelpBlock}.
 * 
 * Example:
 * 
 * <b:FormGroup>
 *   <b:FormLabel for="username">User</b:FormLabel>
 *   <b:TextBox b:id="username" ui:field="username" /> 
 *   <b:HelpBlock iconType="EXCLAMATION" /> 
 * </b:FormGroup>
 * 
 * @author Steven Jardine
 */
public class ValueBoxErrorSupport implements ValueBoxBase.EditorErrorSupport {

    private final Widget inputWidget;

    private HelpBlock validationStateHelpBlock = null;

    private HasValidationState validationStateParent = null;

    private boolean initialized = false;

    public ValueBoxErrorSupport(Widget widget) {
        super();
        assert widget != null;
        inputWidget = widget;
    }

    /**
     * Find the sibling {@link HelpBlock}.
     *
     * @param widget the {@link Widget} to search.
     * @return the found {@link HelpBlock} of null if not found.
     */
    private HelpBlock findHelpBlock(Widget widget) {
        if (widget instanceof HelpBlock) return (HelpBlock) widget;
        // Try and find the HelpBlock in the children of the given widget.
        if (widget instanceof HasWidgets) {
            for (Widget w : (HasWidgets) widget) {
                if (w instanceof HelpBlock) return (HelpBlock) w;
            }
        }
        if (!(widget instanceof HasValidationState)) {
            // Try and find the HelpBlock in the parent of widget.
            return findHelpBlock(widget.getParent());
        }
        return null;
    }

    /**
     * Initialize the instance. We find the parent {@link HasValidationState} and sibling {@link HelpBlock}
     * only 1 time on initialization.
     */
    public void init() {
        if (initialized) return;
        initialized = true;
        Widget parent = inputWidget.getParent();
        while (parent != null && !parent.getClass().getName().equals("com.google.gwt.user.client.ui.Widget")) {
            if (parent instanceof HasValidationState) {
                validationStateParent = (HasValidationState) parent;
                validationStateHelpBlock = findHelpBlock(inputWidget);
            }
            parent = parent.getParent();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
            init();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void showErrors(List<EditorError> errors) {
        init();
        String errorMsg = "";
        if (validationStateParent != null) {
            if (errors == null) {
                validationStateParent.setValidationState(ValidationState.NONE);
            } else {
                validationStateParent.setValidationState(errors.size() <= 0 ? ValidationState.SUCCESS : ValidationState.ERROR);
                for (int index = 0; index < errors.size(); index++) {
                    errorMsg = errors.get(0).getMessage();
                    if (index + 1 < errors.size()) errorMsg += "; ";
                }
            }
        }
        if (validationStateHelpBlock != null) {
            validationStateHelpBlock.setText(errorMsg);
        }
    }

}
