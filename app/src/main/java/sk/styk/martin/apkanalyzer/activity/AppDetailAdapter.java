package sk.styk.martin.apkanalyzer.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import sk.styk.martin.apkanalyzer.R;
import sk.styk.martin.apkanalyzer.activity.detailfragment.AppDetailFragment_Activity;
import sk.styk.martin.apkanalyzer.activity.detailfragment.AppDetailFragment_Certificate;
import sk.styk.martin.apkanalyzer.activity.detailfragment.AppDetailFragment_File;
import sk.styk.martin.apkanalyzer.activity.detailfragment.AppDetailFragment_General;
import sk.styk.martin.apkanalyzer.activity.detailfragment.AppDetailFragment_Permission;
import sk.styk.martin.apkanalyzer.activity.detailfragment.AppDetailFragment_Provider;
import sk.styk.martin.apkanalyzer.activity.detailfragment.AppDetailFragment_Receiver;
import sk.styk.martin.apkanalyzer.activity.detailfragment.AppDetailFragment_Resource;
import sk.styk.martin.apkanalyzer.activity.detailfragment.AppDetailFragment_Service;
import sk.styk.martin.apkanalyzer.model.ActivityData;
import sk.styk.martin.apkanalyzer.model.AppDetailData;
import sk.styk.martin.apkanalyzer.model.BroadcastReceiverData;
import sk.styk.martin.apkanalyzer.model.ContentProviderData;
import sk.styk.martin.apkanalyzer.model.ServiceData;

/**
 * Created by Martin Styk on 18.06.2017.
 */

public class AppDetailAdapter extends FragmentStatePagerAdapter {

    private Fragment[] fragments = new Fragment[getCount()];
    private Context context;
    private AppDetailData data;

    public AppDetailAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        fragments[0] = new AppDetailFragment_General();
        fragments[1] = new AppDetailFragment_Certificate();
        fragments[2] = new AppDetailFragment_Activity();
        fragments[3] = new AppDetailFragment_Service();
        fragments[4] = new AppDetailFragment_Provider();
        fragments[5] = new AppDetailFragment_Receiver();
        fragments[6] = new AppDetailFragment_Permission();
        fragments[7] = new AppDetailFragment_File();
        fragments[8] = new AppDetailFragment_Resource();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragments[position];
        Bundle args = new Bundle();
        switch (position) {
            case 0:
                args.putParcelable(AppDetailFragment.ARG_CHILD, data.getGeneralData());
                break;
            case 1:
                args.putParcelable(AppDetailFragment.ARG_CHILD, data.getCertificateData());
                break;
            case 2:
                args.putParcelableArrayList(AppDetailFragment.ARG_CHILD, (ArrayList<ActivityData>) data.getActivityData());
                break;
            case 3:
                args.putParcelableArrayList(AppDetailFragment.ARG_CHILD, (ArrayList<ServiceData>) data.getServiceData());
                break;
            case 4:
                args.putParcelableArrayList(AppDetailFragment.ARG_CHILD, (ArrayList<ContentProviderData>) data.getContentProviderData());
                break;
            case 5:
                args.putParcelableArrayList(AppDetailFragment.ARG_CHILD, (ArrayList<BroadcastReceiverData>) data.getBroadcastReceiverData());
                break;
            case 6:
                args.putParcelable(AppDetailFragment.ARG_CHILD, data.getPermissionData());
                break;
            case 7:
                args.putParcelable(AppDetailFragment.ARG_CHILD, data.getFileData());
                break;
            case 8:
                args.putParcelable(AppDetailFragment.ARG_CHILD, data.getResourceData());
                break;
            default:
                args.putParcelable(AppDetailFragment.ARG_CHILD, data);
        }

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.general);
            case 1:
                return context.getResources().getString(R.string.certificate);
            case 2:
                return context.getResources().getString(R.string.activities);
            case 3:
                return context.getResources().getString(R.string.services);
            case 4:
                return context.getResources().getString(R.string.content_providers);
            case 5:
                return context.getResources().getString(R.string.broadcast_receivers);
            case 6:
                return context.getResources().getString(R.string.permissions);
            case 7:
                return context.getResources().getString(R.string.files);
            case 8:
                return context.getResources().getString(R.string.resources);
        }
        return "FRAGMENT " + (position + 1);
    }

    public void dataChange(AppDetailData data) {
        this.data = data;
    }

}