package com.example.recipien.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


@ActivityRetainedScoped
class DataSourceRepo @Inject constructor(
    remoteDataSource:RemoteDataSource
) {

    var remoteeDataSource=remoteDataSource
}