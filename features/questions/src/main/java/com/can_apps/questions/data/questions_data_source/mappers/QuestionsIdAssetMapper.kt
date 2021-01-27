package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionCategoryDomainEnum
import com.can_apps.questions.core.QuestionCategoryDomainEnum.BANDITRY
import com.can_apps.questions.core.QuestionCategoryDomainEnum.CRAZY_LIFE
import com.can_apps.questions.core.QuestionCategoryDomainEnum.EXHIBITIONISM
import com.can_apps.questions.core.QuestionCategoryDomainEnum.ILLEGAL_DRUGS
import com.can_apps.questions.core.QuestionCategoryDomainEnum.INVALID
import com.can_apps.questions.core.QuestionCategoryDomainEnum.LEGAL_DRUGS
import com.can_apps.questions.core.QuestionCategoryDomainEnum.MAKE_OUT
import com.can_apps.questions.core.QuestionCategoryDomainEnum.MASTURBATION
import com.can_apps.questions.core.QuestionCategoryDomainEnum.NERVOUS_MOUTH
import com.can_apps.questions.core.QuestionCategoryDomainEnum.PURITY_SEEKER
import com.can_apps.questions.core.QuestionCategoryDomainEnum.SEX
import com.can_apps.questions.core.QuestionCategoryDomainEnum.SINS
import com.can_apps.questions.core.QuestionCategoryDomainEnum.UNIVERSITY_FEELINGS
import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdAssetMapper {

    fun mapAssetId(category: QuestionCategoryDomainEnum, id: Int): QuestionIdDomainEnum
}

internal class QuestionsIdAssetMapperDefault(
    private val idDomainMapper: QuestionsIdAssetToDomainMapper
) : QuestionsIdAssetMapper {

    override fun mapAssetId(category: QuestionCategoryDomainEnum, id: Int): QuestionIdDomainEnum =
        when (category) {
            BANDITRY -> idDomainMapper.mapIdToBanditryDomain(id)
            MAKE_OUT -> idDomainMapper.mapIdToMakeOutDomain(id)
            NERVOUS_MOUTH -> idDomainMapper.mapIdToNervousMouthDomain(id)
            MASTURBATION -> idDomainMapper.mapIdToMasturbationDomain(id)
            SINS -> idDomainMapper.mapIdToSinsDomain(id)
            EXHIBITIONISM -> idDomainMapper.mapIdToExhibitionismDomain(id)
            CRAZY_LIFE -> idDomainMapper.mapIdToCrazyLifeDomain(id)
            LEGAL_DRUGS -> idDomainMapper.mapIdToLegalDrugsDomain(id)
            ILLEGAL_DRUGS -> idDomainMapper.mapIdToIllegalDrugsDomain(id)
            UNIVERSITY_FEELINGS -> idDomainMapper.mapIdToUniFeelingsDomain(id)
            SEX -> idDomainMapper.mapIdToSexDomain(id)
            PURITY_SEEKER -> idDomainMapper.mapIdToPurityDomain(id)
            INVALID -> QuestionIdDomainEnum.INVALID
        }
}
