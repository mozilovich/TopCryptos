package com.example.topcryptos.data

import com.example.topcryptos.data.network.NetworkModule
import dagger.Module

@Module(includes = [NetworkModule::class, GatewayBinder::class])
class DataModule