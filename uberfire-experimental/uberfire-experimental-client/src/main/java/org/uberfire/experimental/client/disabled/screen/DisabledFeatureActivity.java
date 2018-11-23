/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.experimental.client.disabled.screen;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.gwt.user.client.ui.IsWidget;
import org.jboss.errai.common.client.ui.ElementWrapperWidget;
import org.jboss.errai.ui.client.local.spi.TranslationService;
import org.uberfire.client.mvp.AbstractWorkbenchScreenActivity;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.experimental.client.disabled.component.DisabledFeatureComponent;
import org.uberfire.experimental.client.resources.i18n.UberfireExperimentalConstants;

@Dependent
@Named(DisabledFeatureActivity.ID)
public class DisabledFeatureActivity extends AbstractWorkbenchScreenActivity {

    public static final String ID = "appformer.experimental.disabledFeatureTitle";
    public static final String ID_PARAM = "randomId";
    public static final String FEATURE_ID_PARAM = "featureId";

    private DisabledFeatureComponent component;
    private TranslationService translationService;

    @Inject
    public DisabledFeatureActivity(PlaceManager placeManager, DisabledFeatureComponent component, TranslationService translationService) {
        super(placeManager);
        this.component = component;
        this.translationService = translationService;
    }

    @Override
    public void onOpen() {
        super.onOpen();

        component.show(place.getParameter(FEATURE_ID_PARAM, null));
    }

    @Override
    public Object getRealPresenter() {
        return null;
    }

    @Override
    public String getTitle() {
        return translationService.getTranslation(UberfireExperimentalConstants.disabledFeatureTitle);
    }

    @Override
    public IsWidget getWidget() {
        return ElementWrapperWidget.getWidget(component.getElement());
    }

    @Override
    public String getIdentifier() {
        return ID;
    }
}
