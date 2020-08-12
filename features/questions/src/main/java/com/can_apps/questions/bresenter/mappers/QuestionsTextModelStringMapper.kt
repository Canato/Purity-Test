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
            QuestionIdModelEnum.SINS_PRIDE -> stringResource.getString(R.string.sins_pride)
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

    override fun mapCrazyLifeEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.CRAZY_LIFE_ORGY -> stringResource.getString(R.string.crazy_life_orgy)
            QuestionIdModelEnum.CRAZY_LIFE_ORGASM -> stringResource.getString(R.string.crazy_life_orgasm)
            QuestionIdModelEnum.CRAZY_LIFE_HIDE -> stringResource.getString(R.string.crazy_life_hide)
            QuestionIdModelEnum.CRAZY_LIFE_HIDE_SEX -> stringResource.getString(R.string.crazy_life_hide_sex)
            QuestionIdModelEnum.CRAZY_LIFE_KISS_PROSTITUTE -> stringResource.getString(R.string.crazy_life_kiss_prostitute)
            QuestionIdModelEnum.CRAZY_LIFE_POLE_DANCE -> stringResource.getString(R.string.crazy_life_pole_dance)
            QuestionIdModelEnum.CRAZY_LIFE_STRIPPER -> stringResource.getString(R.string.crazy_life_stripper)
            QuestionIdModelEnum.CRAZY_LIFE_WIN_MONEY -> stringResource.getString(R.string.crazy_life_win_money)
            QuestionIdModelEnum.CRAZY_LIFE_PAID_SEX -> stringResource.getString(R.string.crazy_life_paid_sex)
            QuestionIdModelEnum.CRAZY_LIFE_PAID_BODY -> stringResource.getString(R.string.crazy_life_paid_body)
            QuestionIdModelEnum.CRAZY_LIFE_CHEAT -> stringResource.getString(R.string.crazy_life_cheat)
            QuestionIdModelEnum.CRAZY_LIFE_JIGLYPUFF -> stringResource.getString(R.string.crazy_life_jiglypuff)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapLegalDrugsEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.LEGAL_DRUGS_LOT_GOOD -> stringResource.getString(R.string.legal_drugs_lot_good)
            QuestionIdModelEnum.LEGAL_DRUGS_THREE_TOGETHER -> stringResource.getString(R.string.legal_drugs_three_together)
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_VOMIT -> stringResource.getString(R.string.legal_drugs_until_vomit)
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_FALL -> stringResource.getString(R.string.legal_drugs_until_fall)
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_PEE -> stringResource.getString(R.string.legal_drugs_until_pee)
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_FAINT -> stringResource.getString(R.string.legal_drugs_until_faint)
            QuestionIdModelEnum.LEGAL_DRUGS_HOSPITAL -> stringResource.getString(R.string.legal_drugs_hospital)
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_COMA -> stringResource.getString(R.string.legal_drugs_until_coma)
            QuestionIdModelEnum.LEGAL_DRUGS_BE_CRAZY -> stringResource.getString(R.string.legal_drugs_be_crazy)
            QuestionIdModelEnum.LEGAL_DRUGS_TO_FORGET -> stringResource.getString(R.string.legal_drugs_to_forget)
            QuestionIdModelEnum.LEGAL_DRUGS_TO_THROW_UP -> stringResource.getString(R.string.legal_drugs_to_throw_up)
            QuestionIdModelEnum.LEGAL_DRUGS_SEX_SOMEONE -> stringResource.getString(R.string.legal_drugs_sex_someone)
            QuestionIdModelEnum.LEGAL_DRUGS_SEX_YOURSELF -> stringResource.getString(R.string.legal_drugs_sex_yourself)
            QuestionIdModelEnum.LEGAL_DRUGS_BLACKOUT -> stringResource.getString(R.string.legal_drugs_blackout)
            QuestionIdModelEnum.LEGAL_DRUGS_BLACKOUT_SEX -> stringResource.getString(R.string.legal_drugs_blackout_sex)
            QuestionIdModelEnum.LEGAL_DRUGS_CIGARETS -> stringResource.getString(R.string.legal_drugs_cigarets)
            QuestionIdModelEnum.LEGAL_DRUGS_THREE_PER_DAY -> stringResource.getString(R.string.legal_drugs_three_per_day)
            QuestionIdModelEnum.LEGAL_DRUGS_PACK_ONE_PLUS -> stringResource.getString(R.string.legal_drugs_pack_plus_one)
            QuestionIdModelEnum.LEGAL_DRUGS_SMOKE_ORGANIC -> stringResource.getString(R.string.legal_drugs_smoke_organic)
            QuestionIdModelEnum.LEGAL_DRUGS_SMOKE_SHISHA -> stringResource.getString(R.string.legal_drugs_smoke_shisha)
            QuestionIdModelEnum.LEGAL_DRUGS_MEDICINE -> stringResource.getString(R.string.legal_drugs_medicine)
            QuestionIdModelEnum.LEGAL_DRUGS_BLACK_STRIPE -> stringResource.getString(R.string.legal_drugs_black_stripes)
            QuestionIdModelEnum.LEGAL_DRUGS_OWN_BREW -> stringResource.getString(R.string.legal_drugs_own_brew)
            QuestionIdModelEnum.LEGAL_DRUGS_BODY_SHOT -> stringResource.getString(R.string.legal_drugs_body_shot)
            QuestionIdModelEnum.LEGAL_DRUGS_DRINK_FLOOR -> stringResource.getString(R.string.legal_drugs_drink_floor)
            QuestionIdModelEnum.LEGAL_DRUGS_SLEPT_VOMIT -> stringResource.getString(R.string.legal_drugs_slept_vomit)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapIllegalDrugsEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.ILLEGAL_DRUGS_ILLICIT -> stringResource.getString(R.string.illegal_drugs_illicit)
            QuestionIdModelEnum.ILLEGAL_DRUGS_ONE_PLUS -> stringResource.getString(R.string.illegal_drugs_one_plus)
            QuestionIdModelEnum.ILLEGAL_DRUGS_TWO_PLUS -> stringResource.getString(R.string.illegal_drugs_two_plus)
            QuestionIdModelEnum.ILLEGAL_DRUGS_FIVE_PLUS -> stringResource.getString(R.string.illegal_drugs_five_plus)
            QuestionIdModelEnum.ILLEGAL_DRUGS_SYNTHETIC -> stringResource.getString(R.string.illegal_drugs_synthetic)
            QuestionIdModelEnum.ILLEGAL_DRUGS_SHARE -> stringResource.getString(R.string.illegal_drugs_share)
            QuestionIdModelEnum.ILLEGAL_DRUGS_SELL -> stringResource.getString(R.string.illegal_drugs_sell)
            QuestionIdModelEnum.ILLEGAL_DRUGS_BUY -> stringResource.getString(R.string.illegal_drugs_buy)
            QuestionIdModelEnum.ILLEGAL_DRUGS_CULTIVATE -> stringResource.getString(R.string.illegal_drugs_cultivate)
            QuestionIdModelEnum.ILLEGAL_DRUGS_PLANT -> stringResource.getString(R.string.illegal_drugs_plant)
            QuestionIdModelEnum.ILLEGAL_DRUGS_COCAINE -> stringResource.getString(R.string.illegal_drugs_cocaine)
            QuestionIdModelEnum.ILLEGAL_DRUGS_BLACK_OUT -> stringResource.getString(R.string.illegal_drugs_black_out)
            QuestionIdModelEnum.ILLEGAL_DRUGS_SYNTHETIC_EXTEND -> stringResource.getString(R.string.illegal_drugs_synthetic_extend)
            QuestionIdModelEnum.ILLEGAL_DRUGS_CANCELLING -> stringResource.getString(R.string.illegal_drugs_cancelling)
            QuestionIdModelEnum.ILLEGAL_DRUGS_COOKING -> stringResource.getString(R.string.illegal_drugs_cooking)
            QuestionIdModelEnum.ILLEGAL_DRUGS_FORGETTING -> stringResource.getString(R.string.illegal_drugs_forgetting)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapUniFeelingsEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.UNI_FEELINGS_WEEKEND_PARTY_ONCE -> stringResource.getString(R.string.uni_feelings_weekend_party_once)
            QuestionIdModelEnum.UNI_FEELINGS_WEEKEND_PARTY_TWO_PLUS -> stringResource.getString(R.string.uni_feelings_weekend_party_two_plus)
            QuestionIdModelEnum.UNI_FEELINGS_WEEKEND_PARTY_FIVE_PLUS -> stringResource.getString(R.string.uni_feelings_weekend_party_five_plus)
            QuestionIdModelEnum.UNI_FEELINGS_SEX_UNI -> stringResource.getString(R.string.uni_feelings_sex_uni)
            QuestionIdModelEnum.UNI_FEELINGS_SEX_CAFETERIA -> stringResource.getString(R.string.uni_feelings_sex_cafeteria)
            QuestionIdModelEnum.UNI_FEELINGS_SEX_LIBRARY -> stringResource.getString(R.string.uni_feelings_sex_library)
            QuestionIdModelEnum.UNI_FEELINGS_SEX_LAB -> stringResource.getString(R.string.uni_feelings_sex_lab)
            QuestionIdModelEnum.UNI_FEELINGS_SEX_STUDENT_CENTER -> stringResource.getString(R.string.uni_feelings_sex_student_center)
            QuestionIdModelEnum.UNI_FEELINGS_SEX_MAIN_ROOM -> stringResource.getString(R.string.uni_feelings_sex_main_room)
            QuestionIdModelEnum.UNI_FEELINGS_DANCE_TABLE -> stringResource.getString(R.string.uni_feelings_dance_table)
            QuestionIdModelEnum.UNI_FEELINGS_DANCE_TABLE_UNDERWEAR -> stringResource.getString(R.string.uni_feelings_dance_table_underwear)
            else -> stringResource.getString(R.string.questions_id_model_error)
        }

    override fun mapSexEnumToString(id: QuestionIdModelEnum): String =
        when (id) {
            QuestionIdModelEnum.SEX_HAD -> stringResource.getString(R.string.sex_had)
            QuestionIdModelEnum.SEX_BORED -> stringResource.getString(R.string.sex_bored)
            QuestionIdModelEnum.SEX_KNOWN_SHORT -> stringResource.getString(R.string.sex_known_short)
            QuestionIdModelEnum.SEX_SLEPT_DURING -> stringResource.getString(R.string.sex_slept_during)
            QuestionIdModelEnum.SEX_SLEPT_EXTRA -> stringResource.getString(R.string.sex_slept_extra)
            QuestionIdModelEnum.SEX_SLEPT_EXTRA_SAME_BED -> stringResource.getString(R.string.sex_slept_extra_same_bed)
            QuestionIdModelEnum.SEX_SAME_FAMILY -> stringResource.getString(R.string.sex_same_family)
            QuestionIdModelEnum.SEX_MILF -> stringResource.getString(R.string.sex_milf)
            QuestionIdModelEnum.SEX_PREGNANCY -> stringResource.getString(R.string.sex_pregnancy)
            QuestionIdModelEnum.SEX_THREESOME -> stringResource.getString(R.string.sex_threesome)
            QuestionIdModelEnum.SEX_THREESOME_TWO_WOMAN -> stringResource.getString(R.string.sex_threesome_two_woman)
            QuestionIdModelEnum.SEX_THREESOME_TWO_MAN -> stringResource.getString(R.string.sex_threesome_two_man)
            QuestionIdModelEnum.SEX_ORGY -> stringResource.getString(R.string.sex_orgy)
            QuestionIdModelEnum.SEX_SWING -> stringResource.getString(R.string.sex_swing)
            QuestionIdModelEnum.SEX_SAME_NIGHT_TRIPLE -> stringResource.getString(R.string.sex_same_night_triple)
            QuestionIdModelEnum.SEX_LIFE_COUNT_THREE_PLUS -> stringResource.getString(R.string.sex_life_count_three_plus)
            QuestionIdModelEnum.SEX_LIFE_COUNT_TEN_PLUS -> stringResource.getString(R.string.sex_life_count_ten_plus)
            QuestionIdModelEnum.SEX_BELOW_AGE -> stringResource.getString(R.string.sex_below_age)
            QuestionIdModelEnum.SEX_ORAL -> stringResource.getString(R.string.sex_oral)
            QuestionIdModelEnum.SEX_ANAL -> stringResource.getString(R.string.sex_anal)
            QuestionIdModelEnum.SEX_VIRGIN_CHECKED -> stringResource.getString(R.string.sex_virgin_checked)
            QuestionIdModelEnum.SEX_CONDOMLESS -> stringResource.getString(R.string.sex_condomless)
            QuestionIdModelEnum.SEX_TOYS -> stringResource.getString(R.string.sex_toys)
            QuestionIdModelEnum.SEX_UPSIDE_DOWN -> stringResource.getString(R.string.sex_upside_down)
            QuestionIdModelEnum.SEX_PUBLIC -> stringResource.getString(R.string.sex_public)
            QuestionIdModelEnum.SEX_SHOPPING -> stringResource.getString(R.string.sex_shopping)
            QuestionIdModelEnum.SEX_MOVIE_THEATRE -> stringResource.getString(R.string.sex_movie_theatre)
            QuestionIdModelEnum.SEX_FOR_PUBLIC -> stringResource.getString(R.string.sex_for_public)
            QuestionIdModelEnum.SEX_FILMED -> stringResource.getString(R.string.sex_filmed)
            QuestionIdModelEnum.SEX_WITHOUT_CONSENT -> stringResource.getString(R.string.sex_without_consent)
            QuestionIdModelEnum.SEX_ANIMAL -> stringResource.getString(R.string.sex_animal)
            QuestionIdModelEnum.SEX_PLAT -> stringResource.getString(R.string.sex_plat)
            QuestionIdModelEnum.SEX_ROOF -> stringResource.getString(R.string.sex_roof)
            QuestionIdModelEnum.SEX_AQUEOUS -> stringResource.getString(R.string.sex_aqueous)
            QuestionIdModelEnum.SEX_NON_NEWTONIAN -> stringResource.getString(R.string.sex_non_newtonian)
            QuestionIdModelEnum.SEX_EAT_FOOD -> stringResource.getString(R.string.sex_eat_food)
            QuestionIdModelEnum.SEX_SIX_NINE -> stringResource.getString(R.string.sex_six_nine)
            QuestionIdModelEnum.SEX_MULTIPLE_POSITIONS -> stringResource.getString(R.string.sex_multiple_positions)
            QuestionIdModelEnum.SEX_HAMMOCK -> stringResource.getString(R.string.sex_hammock)
            QuestionIdModelEnum.SEX_COLONOSCOPY -> stringResource.getString(R.string.sex_colonoscopy)
            QuestionIdModelEnum.SEX_MENSTRUATION -> stringResource.getString(R.string.sex_menstruation)
            QuestionIdModelEnum.SEX_CLOWN -> stringResource.getString(R.string.sex_clown)
            QuestionIdModelEnum.SEX_SURPRISE_SLIP -> stringResource.getString(R.string.sex_surprise_slip)
            QuestionIdModelEnum.SEX_EXCRETA -> stringResource.getString(R.string.sex_excreta)
            QuestionIdModelEnum.SEX_BUTT_WASHER -> stringResource.getString(R.string.sex_butt_washer)
            QuestionIdModelEnum.SEX_COSTUME -> stringResource.getString(R.string.sex_costume)
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
