package com.can_apps.questions

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.common.CoroutineDispatcherFactory
import com.can_apps.common.CoroutineDispatcherFactoryUnconfined
import com.can_apps.questions.app.QuestionsServiceLocator
import com.can_apps.questions_data_source.data.QuestionsDataSourceAssets
import io.mockk.mockk

internal class MockQuestionsServiceLocator(
    private val stringResource: CommonStringResourceWrapper,
    private val assets: QuestionsDataSourceAssets
) : QuestionsServiceLocator(mockk(relaxed = true)) {

    override fun getAsset(): QuestionsDataSourceAssets = assets

    override fun getStringResource(): CommonStringResourceWrapper = stringResource

    override fun getCoroutineDispatcher(): CoroutineDispatcherFactory = CoroutineDispatcherFactoryUnconfined()
}
