package com.can_apps.questions.bresenter.mappers

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModelEnum

internal interface QuestionsTextModelStringMapper {
    fun mapBanditryEnumToString(id: QuestionIdModelEnum): String
    fun mapMakeOutEnumToString(id: QuestionIdModelEnum): String
    fun mapNervousMouthEnumToString(id: QuestionIdModelEnum): String
    fun mapMasturbationEnumToString(id: QuestionIdModelEnum): String
    fun mapSinsEnumToString(id: QuestionIdModelEnum): String
    fun mapExhibitionismEnumToString(id: QuestionIdModelEnum): String
    fun mapCrazyLifeEnumToString(id: QuestionIdModelEnum): String
    fun mapLegalDrugsEnumToString(id: QuestionIdModelEnum): String
    fun mapIllegalDrugsEnumToString(id: QuestionIdModelEnum): String
    fun mapUniFeelingsEnumToString(id: QuestionIdModelEnum): String
    fun mapSexEnumToString(id: QuestionIdModelEnum): String
    fun mapPurityEnumToString(id: QuestionIdModelEnum): String
    fun mapInvalidEnumToString(id: QuestionIdModelEnum): String
}

internal class QuestionsTextModelStringMapperDefault(private val stringResource: CommonStringResourceWrapper) :
    QuestionsTextModelStringMapper {

    override fun mapBanditryEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.BANDITRY_ABORTION -> stringResource.getString(R.string.banditry_abortion)
            QuestionIdModelEnum.BANDITRY_ACCUSED -> stringResource.getString(R.string.banditry_accused)
            QuestionIdModelEnum.BANDITRY_BOUGHT_STOLEN -> stringResource.getString(R.string.banditry_bought_stolen)
            QuestionIdModelEnum.BANDITRY_DRIVE_DRUNK -> stringResource.getString(R.string.banditry_drive_drunk)
            QuestionIdModelEnum.BANDITRY_JUVENILE -> stringResource.getString(R.string.banditry_juvenile)
            QuestionIdModelEnum.BANDITRY_LOST_LICENCE -> stringResource.getString(R.string.banditry_lost_licence)
            QuestionIdModelEnum.BANDITRY_NOTION -> stringResource.getString(R.string.banditry_notion)
            QuestionIdModelEnum.BANDITRY_POLICE -> stringResource.getString(R.string.banditry_police)
            QuestionIdModelEnum.BANDITRY_PREGNANT -> stringResource.getString(R.string.banditry_pregnant)
            QuestionIdModelEnum.BANDITRY_SOLD_STOLEN -> stringResource.getString(R.string.banditry_sold_stolen)
            QuestionIdModelEnum.BANDITRY_STEALING -> stringResource.getString(R.string.banditry_stealing)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapMakeOutEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.MAKE_OUT_NIGHT_PARTY -> stringResource.getString(R.string.make_out_night_party)
            QuestionIdModelEnum.MAKE_OUT_WITH_PERSON -> stringResource.getString(R.string.make_out_with_person)
            QuestionIdModelEnum.MAKE_OUT_WITH_SAME_GENDER -> stringResource.getString(R.string.make_out_with_same_gender)
            QuestionIdModelEnum.MAKE_OUT_ONE_UNKNOWN -> stringResource.getString(R.string.make_out_one_unknown)
            QuestionIdModelEnum.MAKE_OUT_THREE -> stringResource.getString(R.string.make_out_three)
            QuestionIdModelEnum.MAKE_OUT_HARD -> stringResource.getString(R.string.make_out_hard)
            QuestionIdModelEnum.MAKE_OUT_HARD_DRIVING -> stringResource.getString(R.string.make_out_hard_driving)
            QuestionIdModelEnum.MAKE_OUT_TCHACA -> stringResource.getString(R.string.make_out_tchaca)
            QuestionIdModelEnum.MAKE_OUT_TOUCH_BREAST -> stringResource.getString(R.string.make_out_touch_breast)
            QuestionIdModelEnum.MAKE_OUT_TOUCH_ASS -> stringResource.getString(R.string.make_out_touch_ass)
            QuestionIdModelEnum.MAKE_OUT_TOUCH_GENITALS -> stringResource.getString(R.string.make_out_touch_genitals)
            QuestionIdModelEnum.MAKE_OUT_MOUTH_BREAST -> stringResource.getString(R.string.make_out_mouth_breast)
            QuestionIdModelEnum.MAKE_OUT_MOUTH_GENITALS -> stringResource.getString(R.string.make_out_mouth_genitals)
            QuestionIdModelEnum.MAKE_OUT_MOUTH_SAME_GENDER -> stringResource.getString(R.string.make_out_mouth_same_gender)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapNervousMouthEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.NERVOUS_MOUTH_WITHOUT_TONGUE -> stringResource.getString(R.string.nervous_mouth_without_tongue)
            QuestionIdModelEnum.NERVOUS_MOUTH_WITH_TONGUE -> stringResource.getString(R.string.nervous_mouth_with_tongue)
            QuestionIdModelEnum.NERVOUS_MOUTH_OPPOSITE_GENDER -> stringResource.getString(R.string.nervous_mouth_opposite_gender)
            QuestionIdModelEnum.NERVOUS_MOUTH_SAME_GENDER -> stringResource.getString(R.string.nervous_mouth_same_gender)
            QuestionIdModelEnum.NERVOUS_MOUTH_MORE_THAN_ONE -> stringResource.getString(R.string.nervous_mouth_more_than_one)
            QuestionIdModelEnum.NERVOUS_MOUTH_MORE_THAN_ONE_OPPOSITE -> stringResource.getString(R.string.nervous_mouth_more_than_one_opposite)
            QuestionIdModelEnum.NERVOUS_MOUTH_MORE_THAN_ONE_SAME -> stringResource.getString(R.string.nervous_mouth_more_than_one_same)
            QuestionIdModelEnum.NERVOUS_MOUTH_EAR -> stringResource.getString(R.string.nervous_mouth_ear)
            QuestionIdModelEnum.NERVOUS_MOUTH_NECK -> stringResource.getString(R.string.nervous_mouth_neck)
            QuestionIdModelEnum.NERVOUS_MOUTH_SHOULDER -> stringResource.getString(R.string.nervous_mouth_shoulder)
            QuestionIdModelEnum.NERVOUS_MOUTH_WAIST -> stringResource.getString(R.string.nervous_mouth_waist)
            QuestionIdModelEnum.NERVOUS_MOUTH_GENITALS -> stringResource.getString(R.string.nervous_mouth_genitals)
            QuestionIdModelEnum.NERVOUS_MOUTH_GAME_KISS -> stringResource.getString(R.string.nervous_mouth_game_kiss)
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_TRIPLE -> stringResource.getString(R.string.nervous_mouth_kiss_triple)
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_QUADRUPLE -> stringResource.getString(R.string.nervous_mouth_kiss_quadruple)
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_MORE -> stringResource.getString(R.string.nervous_mouth_kiss_more)
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_GREEK -> stringResource.getString(R.string.nervous_mouth_kiss_greek)
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_FRANCO_GREEK -> stringResource.getString(R.string.nervous_mouth_kiss_franco_greek)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapMasturbationEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.MASTURBATION_SOLO -> stringResource.getString(R.string.masturbation_solo)
            QuestionIdModelEnum.MASTURBATION_TWO_MORE -> stringResource.getString(R.string.masturbation_two_more)
            QuestionIdModelEnum.MASTURBATION_PHONE -> stringResource.getString(R.string.masturbation_phone)
            QuestionIdModelEnum.MASTURBATION_VIDEO_CALL -> stringResource.getString(R.string.masturbation_video_call)
            QuestionIdModelEnum.MASTURBATION_OBJECT -> stringResource.getString(R.string.masturbation_object)
            QuestionIdModelEnum.MASTURBATION_FOOD -> stringResource.getString(R.string.masturbation_food)
            QuestionIdModelEnum.MASTURBATION_GIVEN -> stringResource.getString(R.string.masturbation_given)
            QuestionIdModelEnum.MASTURBATION_TAKEN -> stringResource.getString(R.string.masturbation_taken)
            QuestionIdModelEnum.MASTURBATION_CAUGHT -> stringResource.getString(R.string.masturbation_caught)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapSinsEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.SINS_GLUTTONY -> stringResource.getString(R.string.sins_gluttony)
            QuestionIdModelEnum.SINS_GREED -> stringResource.getString(R.string.sins_greed)
            QuestionIdModelEnum.SINS_LUST -> stringResource.getString(R.string.sins_lust)
            QuestionIdModelEnum.SINS_WRATH -> stringResource.getString(R.string.sins_wrath)
            QuestionIdModelEnum.SINS_ENVY -> stringResource.getString(R.string.sins_envy)
            QuestionIdModelEnum.SINS_SLOTH -> stringResource.getString(R.string.sins_sloth)
            QuestionIdModelEnum.SINS_PRIDE -> stringResource.getString(R.string.questions_id_model_error)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapExhibitionismEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.EXHIBITIONISM_SEXUAL_ACTION -> stringResource.getString(R.string.exhibitionism_sexual_action)
            QuestionIdModelEnum.EXHIBITIONISM_SWIM -> stringResource.getString(R.string.exhibitionism_swim)
            QuestionIdModelEnum.EXHIBITIONISM_RUN -> stringResource.getString(R.string.exhibitionism_run)
            QuestionIdModelEnum.EXHIBITIONISM_XEROX -> stringResource.getString(R.string.exhibitionism_xerox)
            QuestionIdModelEnum.EXHIBITIONISM_SEX_CLOTHES -> stringResource.getString(R.string.exhibitionism_sex_clothes)
            QuestionIdModelEnum.EXHIBITIONISM_FLASHING -> stringResource.getString(R.string.exhibitionism_flashing)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapCrazyLifeEnumToString(id: QuestionIdModelEnum): String {
        TODO("Not yet implemented")
    }

    override fun mapLegalDrugsEnumToString(id: QuestionIdModelEnum): String {
        TODO("Not yet implemented")
    }

    override fun mapIllegalDrugsEnumToString(id: QuestionIdModelEnum): String {
        TODO("Not yet implemented")
    }

    override fun mapUniFeelingsEnumToString(id: QuestionIdModelEnum): String {
        TODO("Not yet implemented")
    }

    override fun mapSexEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.INVALID -> stringResource.getString(R.string.sex_same)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapPurityEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.PURITY_SEEKER_TODO -> stringResource.getString(R.string.purity_seeker_todo)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapInvalidEnumToString(id: QuestionIdModelEnum): String =
        stringResource.getString(R.string.questions_id_model_error)
}
