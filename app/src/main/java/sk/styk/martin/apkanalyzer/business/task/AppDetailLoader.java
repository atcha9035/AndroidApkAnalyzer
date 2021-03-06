package sk.styk.martin.apkanalyzer.business.task;

import android.content.Context;

import sk.styk.martin.apkanalyzer.business.service.AppDetailDataService;
import sk.styk.martin.apkanalyzer.model.detail.AppDetailData;

/**
 * Loader async task for item for AppDetailFragment and AppDetailActivity
 * <p>
 * Created by Martin Styk on 15.06.2017.
 */
public class AppDetailLoader extends ApkAnalyzerAbstractAsyncLoader<AppDetailData> {

    public static final int ID = 2;
    private final AppDetailDataService appDetailDataService;

    private String packageName;
    private String pathToPackage;

    public AppDetailLoader(Context context, String packageName, String pathToPackage) {
        super(context);
        this.packageName = packageName;
        this.pathToPackage = pathToPackage;
        appDetailDataService = new AppDetailDataService(context.getPackageManager());
    }

    @Override
    public AppDetailData loadInBackground() {
        return appDetailDataService.get(packageName, pathToPackage);
    }

}

