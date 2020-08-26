package com.akvelon.domain.usecases.settings.save

import com.akvelon.domain.usecases.base.SuspendUsecase

interface SaveShowDoneToDosUsecase : SuspendUsecase<SaveShowDoneToDosUsecase.Params, Unit> {
    class Params(val show: Boolean)
}