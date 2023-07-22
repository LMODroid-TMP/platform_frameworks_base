/*
 * Copyright (C) 2019 The Android Open Source Project
 *
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
 */

package com.android.systemui.qs;

<<<<<<< HEAD
import android.os.Bundle;

import com.android.systemui.R;
import com.android.systemui.battery.BatteryMeterViewController;
import com.android.systemui.demomode.DemoMode;
import com.android.systemui.demomode.DemoModeController;
import com.android.systemui.flags.FeatureFlags;
import com.android.systemui.flags.Flags;
import com.android.systemui.qs.carrier.QSCarrierGroupController;
=======
>>>>>>> a8b38901158de0bdf294c4814c60b8f4ee359cb1
import com.android.systemui.qs.dagger.QSScope;
import com.android.systemui.util.ViewController;

import javax.inject.Inject;

/**
 * Controller for {@link QuickStatusBarHeader}.
 */
@QSScope
class QuickStatusBarHeaderController extends ViewController<QuickStatusBarHeader> {

    private final QuickQSPanelController mQuickQSPanelController;
    private boolean mListening;

    @Inject
    QuickStatusBarHeaderController(QuickStatusBarHeader view,
<<<<<<< HEAD
            HeaderPrivacyIconsController headerPrivacyIconsController,
            StatusBarIconController statusBarIconController,
            DemoModeController demoModeController,
            QuickQSPanelController quickQSPanelController,
            QSCarrierGroupController.Builder qsCarrierGroupControllerBuilder,
            QSExpansionPathInterpolator qsExpansionPathInterpolator,
            FeatureFlags featureFlags,
            VariableDateViewController.Factory variableDateViewControllerFactory,
            BatteryMeterViewController batteryMeterViewController,
            StatusBarContentInsetsProvider statusBarContentInsetsProvider,
            StatusBarIconController.TintedIconManager.Factory tintedIconManagerFactory) {
=======
            QuickQSPanelController quickQSPanelController
    ) {
>>>>>>> a8b38901158de0bdf294c4814c60b8f4ee359cb1
        super(view);
        mQuickQSPanelController = quickQSPanelController;
<<<<<<< HEAD
        mQSExpansionPathInterpolator = qsExpansionPathInterpolator;
        mFeatureFlags = featureFlags;
        mBatteryMeterViewController = batteryMeterViewController;
        mInsetsProvider = statusBarContentInsetsProvider;

        mQSCarrierGroupController = qsCarrierGroupControllerBuilder
                .setQSCarrierGroup(mView.findViewById(R.id.carrier_group))
                .build();
        mClockView = mView.findViewById(R.id.clock);
        mIconContainer = mView.findViewById(R.id.statusIcons);
        mVariableDateViewControllerDateView = variableDateViewControllerFactory.create(
                mView.requireViewById(R.id.date)
        );
        mVariableDateViewControllerClockDateView = variableDateViewControllerFactory.create(
                mView.requireViewById(R.id.date_clock)
        );

        mIconManager = tintedIconManagerFactory.create(mIconContainer, StatusBarLocation.QS);
        mDemoModeReceiver = new ClockDemoModeReceiver(mClockView);

        // Don't need to worry about tuner settings for this icon
        mBatteryMeterViewController.ignoreTunerUpdates();
    }

    @Override
    protected void onInit() {
        mBatteryMeterViewController.init();
=======
>>>>>>> a8b38901158de0bdf294c4814c60b8f4ee359cb1
    }

    @Override
    protected void onViewAttached() {
<<<<<<< HEAD
        mPrivacyIconsController.onParentVisible();
        mPrivacyIconsController.setChipVisibilityListener(this);
        mIconContainer.addIgnoredSlot(
                getResources().getString(com.android.internal.R.string.status_bar_managed_profile));
        mIconContainer.setShouldRestrictIcons(false);
        mStatusBarIconController.addIconGroup(mIconManager);

        mView.setIsSingleCarrier(mQSCarrierGroupController.isSingleCarrier());
        mQSCarrierGroupController
                .setOnSingleCarrierChangedListener(mView::setIsSingleCarrier);

        List<String> rssiIgnoredSlots = List.of(
                getResources().getString(com.android.internal.R.string.status_bar_mobile)
        );

        mView.onAttach(mIconManager, mQSExpansionPathInterpolator, rssiIgnoredSlots,
                mInsetsProvider, mFeatureFlags.isEnabled(Flags.COMBINED_QS_HEADERS));

        mDemoModeController.addCallback(mDemoModeReceiver);

        mVariableDateViewControllerDateView.init();
        mVariableDateViewControllerClockDateView.init();
=======
>>>>>>> a8b38901158de0bdf294c4814c60b8f4ee359cb1
    }

    @Override
    protected void onViewDetached() {
<<<<<<< HEAD
        mPrivacyIconsController.onParentInvisible();
        mStatusBarIconController.removeIconGroup(mIconManager);
        mQSCarrierGroupController.setOnSingleCarrierChangedListener(null);
        mDemoModeController.removeCallback(mDemoModeReceiver);
=======
>>>>>>> a8b38901158de0bdf294c4814c60b8f4ee359cb1
        setListening(false);
    }

    public void setListening(boolean listening) {
        if (listening == mListening) {
            return;
        }
        mListening = listening;

        mQuickQSPanelController.setListening(listening);

        if (mQuickQSPanelController.switchTileLayout(false)) {
            mView.updateResources();
        }
    }

    public void setContentMargins(int marginStart, int marginEnd) {
        mQuickQSPanelController.setContentMargins(marginStart, marginEnd);
    }
}
