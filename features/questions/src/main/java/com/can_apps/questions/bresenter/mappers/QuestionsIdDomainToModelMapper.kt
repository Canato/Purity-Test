package com.can_apps.questions.bresenter.mappers

import com.can_apps.questions.bresenter.QuestionIdModelEnum
import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdDomainToModelMapper {
    fun mapIdToBanditryModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToMakeOutModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToNervousMouthModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToMasturbationModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToSinsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToExhibitionismModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToCrazyLifeModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToLegalDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToIllegalDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToUniFeelingsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToSexModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
    fun mapIdToPurityModel(id: QuestionIdDomainEnum): QuestionIdModelEnum
}

internal class QuestionsIdDomainToModelMapperDefault() : QuestionsIdDomainToModelMapper {

    override fun mapIdToBanditryModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.BANDITRY_ABORTION -> QuestionIdModelEnum.BANDITRY_ABORTION
            QuestionIdDomainEnum.BANDITRY_ACCUSED -> QuestionIdModelEnum.BANDITRY_ACCUSED
            QuestionIdDomainEnum.BANDITRY_BOUGHT_STOLEN -> QuestionIdModelEnum.BANDITRY_BOUGHT_STOLEN
            QuestionIdDomainEnum.BANDITRY_DRIVE_DRUNK -> QuestionIdModelEnum.BANDITRY_DRIVE_DRUNK
            QuestionIdDomainEnum.BANDITRY_JUVENILE -> QuestionIdModelEnum.BANDITRY_JUVENILE
            QuestionIdDomainEnum.BANDITRY_LOST_LICENCE -> QuestionIdModelEnum.BANDITRY_LOST_LICENCE
            QuestionIdDomainEnum.BANDITRY_NOTION -> QuestionIdModelEnum.BANDITRY_NOTION
            QuestionIdDomainEnum.BANDITRY_POLICE -> QuestionIdModelEnum.BANDITRY_POLICE
            QuestionIdDomainEnum.BANDITRY_PREGNANT -> QuestionIdModelEnum.BANDITRY_PREGNANT
            QuestionIdDomainEnum.BANDITRY_SOLD_STOLEN -> QuestionIdModelEnum.BANDITRY_SOLD_STOLEN
            QuestionIdDomainEnum.BANDITRY_STEALING -> QuestionIdModelEnum.BANDITRY_STEALING
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToMakeOutModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.MAKE_OUT_NIGHT_PARTY -> QuestionIdModelEnum.MAKE_OUT_NIGHT_PARTY
            QuestionIdDomainEnum.MAKE_OUT_WITH_PERSON -> QuestionIdModelEnum.MAKE_OUT_WITH_PERSON
            QuestionIdDomainEnum.MAKE_OUT_WITH_SAME_GENDER -> QuestionIdModelEnum.MAKE_OUT_WITH_SAME_GENDER
            QuestionIdDomainEnum.MAKE_OUT_ONE_UNKNOWN -> QuestionIdModelEnum.MAKE_OUT_ONE_UNKNOWN
            QuestionIdDomainEnum.MAKE_OUT_THREE -> QuestionIdModelEnum.MAKE_OUT_THREE
            QuestionIdDomainEnum.MAKE_OUT_HARD -> QuestionIdModelEnum.MAKE_OUT_HARD
            QuestionIdDomainEnum.MAKE_OUT_HARD_DRIVING -> QuestionIdModelEnum.MAKE_OUT_HARD_DRIVING
            QuestionIdDomainEnum.MAKE_OUT_TCHACA -> QuestionIdModelEnum.MAKE_OUT_TCHACA
            QuestionIdDomainEnum.MAKE_OUT_TOUCH_BREAST -> QuestionIdModelEnum.MAKE_OUT_TOUCH_BREAST
            QuestionIdDomainEnum.MAKE_OUT_TOUCH_ASS -> QuestionIdModelEnum.MAKE_OUT_TOUCH_ASS
            QuestionIdDomainEnum.MAKE_OUT_TOUCH_GENITALS -> QuestionIdModelEnum.MAKE_OUT_TOUCH_GENITALS
            QuestionIdDomainEnum.MAKE_OUT_MOUTH_BREAST -> QuestionIdModelEnum.MAKE_OUT_MOUTH_BREAST
            QuestionIdDomainEnum.MAKE_OUT_MOUTH_GENITALS -> QuestionIdModelEnum.MAKE_OUT_MOUTH_GENITALS
            QuestionIdDomainEnum.MAKE_OUT_MOUTH_SAME_GENDER -> QuestionIdModelEnum.MAKE_OUT_MOUTH_SAME_GENDER
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToNervousMouthModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.NERVOUS_MOUTH_WITHOUT_TONGUE -> QuestionIdModelEnum.NERVOUS_MOUTH_WITHOUT_TONGUE
            QuestionIdDomainEnum.NERVOUS_MOUTH_WITH_TONGUE -> QuestionIdModelEnum.NERVOUS_MOUTH_WITH_TONGUE
            QuestionIdDomainEnum.NERVOUS_MOUTH_OPPOSITE_GENDER -> QuestionIdModelEnum.NERVOUS_MOUTH_OPPOSITE_GENDER
            QuestionIdDomainEnum.NERVOUS_MOUTH_SAME_GENDER -> QuestionIdModelEnum.NERVOUS_MOUTH_SAME_GENDER
            QuestionIdDomainEnum.NERVOUS_MOUTH_MORE_THAN_ONE -> QuestionIdModelEnum.NERVOUS_MOUTH_MORE_THAN_ONE
            QuestionIdDomainEnum.NERVOUS_MOUTH_MORE_THAN_ONE_OPPOSITE -> QuestionIdModelEnum.NERVOUS_MOUTH_MORE_THAN_ONE_OPPOSITE
            QuestionIdDomainEnum.NERVOUS_MOUTH_MORE_THAN_ONE_SAME -> QuestionIdModelEnum.NERVOUS_MOUTH_MORE_THAN_ONE_SAME
            QuestionIdDomainEnum.NERVOUS_MOUTH_EAR -> QuestionIdModelEnum.NERVOUS_MOUTH_EAR
            QuestionIdDomainEnum.NERVOUS_MOUTH_NECK -> QuestionIdModelEnum.NERVOUS_MOUTH_NECK
            QuestionIdDomainEnum.NERVOUS_MOUTH_SHOULDER -> QuestionIdModelEnum.NERVOUS_MOUTH_SHOULDER
            QuestionIdDomainEnum.NERVOUS_MOUTH_WAIST -> QuestionIdModelEnum.NERVOUS_MOUTH_WAIST
            QuestionIdDomainEnum.NERVOUS_MOUTH_GENITALS -> QuestionIdModelEnum.NERVOUS_MOUTH_GENITALS
            QuestionIdDomainEnum.NERVOUS_MOUTH_GAME_KISS -> QuestionIdModelEnum.NERVOUS_MOUTH_GAME_KISS
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_TRIPLE -> QuestionIdModelEnum.NERVOUS_MOUTH_KISS_TRIPLE
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_QUADRUPLE -> QuestionIdModelEnum.NERVOUS_MOUTH_KISS_QUADRUPLE
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_MORE -> QuestionIdModelEnum.NERVOUS_MOUTH_KISS_MORE
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_GREEK -> QuestionIdModelEnum.NERVOUS_MOUTH_KISS_GREEK
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_FRANCO_GREEK -> QuestionIdModelEnum.NERVOUS_MOUTH_KISS_FRANCO_GREEK
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToMasturbationModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.MASTURBATION_SOLO -> QuestionIdModelEnum.MASTURBATION_SOLO
            QuestionIdDomainEnum.MASTURBATION_TWO_MORE -> QuestionIdModelEnum.MASTURBATION_TWO_MORE
            QuestionIdDomainEnum.MASTURBATION_PHONE -> QuestionIdModelEnum.MASTURBATION_PHONE
            QuestionIdDomainEnum.MASTURBATION_VIDEO_CALL -> QuestionIdModelEnum.MASTURBATION_VIDEO_CALL
            QuestionIdDomainEnum.MASTURBATION_OBJECT -> QuestionIdModelEnum.MASTURBATION_OBJECT
            QuestionIdDomainEnum.MASTURBATION_FOOD -> QuestionIdModelEnum.MASTURBATION_FOOD
            QuestionIdDomainEnum.MASTURBATION_GIVEN -> QuestionIdModelEnum.MASTURBATION_GIVEN
            QuestionIdDomainEnum.MASTURBATION_TAKEN -> QuestionIdModelEnum.MASTURBATION_TAKEN
            QuestionIdDomainEnum.MASTURBATION_CAUGHT -> QuestionIdModelEnum.MASTURBATION_CAUGHT
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToSinsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.SINS_GLUTTONY -> QuestionIdModelEnum.SINS_GLUTTONY
            QuestionIdDomainEnum.SINS_GREED -> QuestionIdModelEnum.SINS_GREED
            QuestionIdDomainEnum.SINS_LUST -> QuestionIdModelEnum.SINS_LUST
            QuestionIdDomainEnum.SINS_WRATH -> QuestionIdModelEnum.SINS_WRATH
            QuestionIdDomainEnum.SINS_ENVY -> QuestionIdModelEnum.SINS_ENVY
            QuestionIdDomainEnum.SINS_SLOTH -> QuestionIdModelEnum.SINS_SLOTH
            QuestionIdDomainEnum.SINS_PRIDE -> QuestionIdModelEnum.SINS_PRIDE
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToExhibitionismModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.EXHIBITIONISM_SEXUAL_ACTION -> QuestionIdModelEnum.EXHIBITIONISM_SEXUAL_ACTION
            QuestionIdDomainEnum.EXHIBITIONISM_SWIM -> QuestionIdModelEnum.EXHIBITIONISM_SWIM
            QuestionIdDomainEnum.EXHIBITIONISM_RUN -> QuestionIdModelEnum.EXHIBITIONISM_RUN
            QuestionIdDomainEnum.EXHIBITIONISM_XEROX -> QuestionIdModelEnum.EXHIBITIONISM_XEROX
            QuestionIdDomainEnum.EXHIBITIONISM_SEX_CLOTHES -> QuestionIdModelEnum.EXHIBITIONISM_SEX_CLOTHES
            QuestionIdDomainEnum.EXHIBITIONISM_FLASHING -> QuestionIdModelEnum.EXHIBITIONISM_FLASHING
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToCrazyLifeModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.CRAZY_LIFE_ORGY -> QuestionIdModelEnum.CRAZY_LIFE_ORGY
            QuestionIdDomainEnum.CRAZY_LIFE_ORGASM -> QuestionIdModelEnum.CRAZY_LIFE_ORGASM
            QuestionIdDomainEnum.CRAZY_LIFE_HIDE -> QuestionIdModelEnum.CRAZY_LIFE_HIDE
            QuestionIdDomainEnum.CRAZY_LIFE_HIDE_SEX -> QuestionIdModelEnum.CRAZY_LIFE_HIDE_SEX
            QuestionIdDomainEnum.CRAZY_LIFE_KISS_PROSTITUTE -> QuestionIdModelEnum.CRAZY_LIFE_KISS_PROSTITUTE
            QuestionIdDomainEnum.CRAZY_LIFE_POLE_DANCE -> QuestionIdModelEnum.CRAZY_LIFE_POLE_DANCE
            QuestionIdDomainEnum.CRAZY_LIFE_STRIPPER -> QuestionIdModelEnum.CRAZY_LIFE_STRIPPER
            QuestionIdDomainEnum.CRAZY_LIFE_WIN_MONEY -> QuestionIdModelEnum.CRAZY_LIFE_WIN_MONEY
            QuestionIdDomainEnum.CRAZY_LIFE_PAID_SEX -> QuestionIdModelEnum.CRAZY_LIFE_PAID_SEX
            QuestionIdDomainEnum.CRAZY_LIFE_PAID_BODY -> QuestionIdModelEnum.CRAZY_LIFE_PAID_BODY
            QuestionIdDomainEnum.CRAZY_LIFE_CHEAT -> QuestionIdModelEnum.CRAZY_LIFE_CHEAT
            QuestionIdDomainEnum.CRAZY_LIFE_JIGLYPUFF -> QuestionIdModelEnum.CRAZY_LIFE_JIGLYPUFF
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToLegalDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.LEGAL_DRUGS_LOT_GOOD -> QuestionIdModelEnum.LEGAL_DRUGS_LOT_GOOD
            QuestionIdDomainEnum.LEGAL_DRUGS_THREE_TOGETHER -> QuestionIdModelEnum.LEGAL_DRUGS_THREE_TOGETHER
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_VOMIT -> QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_VOMIT
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_FALL -> QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_FALL
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_PEE -> QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_PEE
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_FAINT -> QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_FAINT
            QuestionIdDomainEnum.LEGAL_DRUGS_HOSPITAL -> QuestionIdModelEnum.LEGAL_DRUGS_HOSPITAL
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_COMA -> QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_COMA
            QuestionIdDomainEnum.LEGAL_DRUGS_BE_CRAZY -> QuestionIdModelEnum.LEGAL_DRUGS_BE_CRAZY
            QuestionIdDomainEnum.LEGAL_DRUGS_TO_FORGET -> QuestionIdModelEnum.LEGAL_DRUGS_TO_FORGET
            QuestionIdDomainEnum.LEGAL_DRUGS_TO_THROW_UP -> QuestionIdModelEnum.LEGAL_DRUGS_TO_THROW_UP
            QuestionIdDomainEnum.LEGAL_DRUGS_SEX_SOMEONE -> QuestionIdModelEnum.LEGAL_DRUGS_SEX_SOMEONE
            QuestionIdDomainEnum.LEGAL_DRUGS_SEX_YOURSELF -> QuestionIdModelEnum.LEGAL_DRUGS_SEX_YOURSELF
            QuestionIdDomainEnum.LEGAL_DRUGS_BLACKOUT -> QuestionIdModelEnum.LEGAL_DRUGS_BLACKOUT
            QuestionIdDomainEnum.LEGAL_DRUGS_BLACKOUT_SEX -> QuestionIdModelEnum.LEGAL_DRUGS_BLACKOUT_SEX
            QuestionIdDomainEnum.LEGAL_DRUGS_CIGARETS -> QuestionIdModelEnum.LEGAL_DRUGS_CIGARETS
            QuestionIdDomainEnum.LEGAL_DRUGS_THREE_PER_DAY -> QuestionIdModelEnum.LEGAL_DRUGS_THREE_PER_DAY
            QuestionIdDomainEnum.LEGAL_DRUGS_PACK_ONE_PLUS -> QuestionIdModelEnum.LEGAL_DRUGS_PACK_ONE_PLUS
            QuestionIdDomainEnum.LEGAL_DRUGS_SMOKE_ORGANIC -> QuestionIdModelEnum.LEGAL_DRUGS_SMOKE_ORGANIC
            QuestionIdDomainEnum.LEGAL_DRUGS_SMOKE_SHISHA -> QuestionIdModelEnum.LEGAL_DRUGS_SMOKE_SHISHA
            QuestionIdDomainEnum.LEGAL_DRUGS_MEDICINE -> QuestionIdModelEnum.LEGAL_DRUGS_MEDICINE
            QuestionIdDomainEnum.LEGAL_DRUGS_BLACK_STRIPE -> QuestionIdModelEnum.LEGAL_DRUGS_BLACK_STRIPE
            QuestionIdDomainEnum.LEGAL_DRUGS_OWN_BREW -> QuestionIdModelEnum.LEGAL_DRUGS_OWN_BREW
            QuestionIdDomainEnum.LEGAL_DRUGS_BODY_SHOT -> QuestionIdModelEnum.LEGAL_DRUGS_BODY_SHOT
            QuestionIdDomainEnum.LEGAL_DRUGS_DRINK_FLOOR -> QuestionIdModelEnum.LEGAL_DRUGS_DRINK_FLOOR
            QuestionIdDomainEnum.LEGAL_DRUGS_SLEPT_VOMIT -> QuestionIdModelEnum.LEGAL_DRUGS_SLEPT_VOMIT
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToIllegalDrugsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.ILLEGAL_DRUGS_ILLICIT -> QuestionIdModelEnum.ILLEGAL_DRUGS_ILLICIT
            QuestionIdDomainEnum.ILLEGAL_DRUGS_ONE_PLUS -> QuestionIdModelEnum.ILLEGAL_DRUGS_ONE_PLUS
            QuestionIdDomainEnum.ILLEGAL_DRUGS_TWO_PLUS -> QuestionIdModelEnum.ILLEGAL_DRUGS_TWO_PLUS
            QuestionIdDomainEnum.ILLEGAL_DRUGS_FIVE_PLUS -> QuestionIdModelEnum.ILLEGAL_DRUGS_FIVE_PLUS
            QuestionIdDomainEnum.ILLEGAL_DRUGS_SYNTHETIC -> QuestionIdModelEnum.ILLEGAL_DRUGS_SYNTHETIC
            QuestionIdDomainEnum.ILLEGAL_DRUGS_SHARE -> QuestionIdModelEnum.ILLEGAL_DRUGS_SHARE
            QuestionIdDomainEnum.ILLEGAL_DRUGS_SELL -> QuestionIdModelEnum.ILLEGAL_DRUGS_SELL
            QuestionIdDomainEnum.ILLEGAL_DRUGS_BUY -> QuestionIdModelEnum.ILLEGAL_DRUGS_BUY
            QuestionIdDomainEnum.ILLEGAL_DRUGS_CULTIVATE -> QuestionIdModelEnum.ILLEGAL_DRUGS_CULTIVATE
            QuestionIdDomainEnum.ILLEGAL_DRUGS_PLANT -> QuestionIdModelEnum.ILLEGAL_DRUGS_PLANT
            QuestionIdDomainEnum.ILLEGAL_DRUGS_COCAINE -> QuestionIdModelEnum.ILLEGAL_DRUGS_COCAINE
            QuestionIdDomainEnum.ILLEGAL_DRUGS_BLACK_OUT -> QuestionIdModelEnum.ILLEGAL_DRUGS_BLACK_OUT
            QuestionIdDomainEnum.ILLEGAL_DRUGS_SYNTHETIC_EXTEND -> QuestionIdModelEnum.ILLEGAL_DRUGS_SYNTHETIC_EXTEND
            QuestionIdDomainEnum.ILLEGAL_DRUGS_CANCELLING -> QuestionIdModelEnum.ILLEGAL_DRUGS_CANCELLING
            QuestionIdDomainEnum.ILLEGAL_DRUGS_COOKING -> QuestionIdModelEnum.ILLEGAL_DRUGS_COOKING
            QuestionIdDomainEnum.ILLEGAL_DRUGS_FORGETTING -> QuestionIdModelEnum.ILLEGAL_DRUGS_FORGETTING
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToUniFeelingsModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.UNI_FEELINGS_WEEKEND_PARTY_ONCE -> QuestionIdModelEnum.UNI_FEELINGS_WEEKEND_PARTY_ONCE
            QuestionIdDomainEnum.UNI_FEELINGS_WEEKEND_PARTY_TWO_PLUS -> QuestionIdModelEnum.UNI_FEELINGS_WEEKEND_PARTY_TWO_PLUS
            QuestionIdDomainEnum.UNI_FEELINGS_WEEKEND_PARTY_FIVE_PLUS -> QuestionIdModelEnum.UNI_FEELINGS_WEEKEND_PARTY_FIVE_PLUS
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_UNI -> QuestionIdModelEnum.UNI_FEELINGS_SEX_UNI
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_CAFETERIA -> QuestionIdModelEnum.UNI_FEELINGS_SEX_CAFETERIA
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_LIBRARY -> QuestionIdModelEnum.UNI_FEELINGS_SEX_LIBRARY
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_LAB -> QuestionIdModelEnum.UNI_FEELINGS_SEX_LAB
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_STUDENT_CENTER -> QuestionIdModelEnum.UNI_FEELINGS_SEX_STUDENT_CENTER
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_MAIN_ROOM -> QuestionIdModelEnum.UNI_FEELINGS_SEX_MAIN_ROOM
            QuestionIdDomainEnum.UNI_FEELINGS_DANCE_TABLE -> QuestionIdModelEnum.UNI_FEELINGS_DANCE_TABLE
            QuestionIdDomainEnum.UNI_FEELINGS_DANCE_TABLE_UNDERWEAR -> QuestionIdModelEnum.UNI_FEELINGS_DANCE_TABLE_UNDERWEAR
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToSexModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.SEX_HAD -> QuestionIdModelEnum.SEX_HAD
            QuestionIdDomainEnum.SEX_BORED -> QuestionIdModelEnum.SEX_BORED
            QuestionIdDomainEnum.SEX_KNOWN_SHORT -> QuestionIdModelEnum.SEX_KNOWN_SHORT
            QuestionIdDomainEnum.SEX_SLEPT_DURING -> QuestionIdModelEnum.SEX_SLEPT_DURING
            QuestionIdDomainEnum.SEX_SLEPT_EXTRA -> QuestionIdModelEnum.SEX_SLEPT_EXTRA
            QuestionIdDomainEnum.SEX_SLEPT_EXTRA_SAME_BED -> QuestionIdModelEnum.SEX_SLEPT_EXTRA_SAME_BED
            QuestionIdDomainEnum.SEX_SAME_FAMILY -> QuestionIdModelEnum.SEX_SAME_FAMILY
            QuestionIdDomainEnum.SEX_MILF -> QuestionIdModelEnum.SEX_MILF
            QuestionIdDomainEnum.SEX_PREGNANCY -> QuestionIdModelEnum.SEX_PREGNANCY
            QuestionIdDomainEnum.SEX_THREESOME -> QuestionIdModelEnum.SEX_THREESOME
            QuestionIdDomainEnum.SEX_THREESOME_TWO_WOMAN -> QuestionIdModelEnum.SEX_THREESOME_TWO_WOMAN
            QuestionIdDomainEnum.SEX_THREESOME_TWO_MAN -> QuestionIdModelEnum.SEX_THREESOME_TWO_MAN
            QuestionIdDomainEnum.SEX_ORGY -> QuestionIdModelEnum.SEX_ORGY
            QuestionIdDomainEnum.SEX_SWING -> QuestionIdModelEnum.SEX_SWING
            QuestionIdDomainEnum.SEX_SAME_NIGHT_TRIPLE -> QuestionIdModelEnum.SEX_SAME_NIGHT_TRIPLE
            QuestionIdDomainEnum.SEX_LIFE_COUNT_THREE_PLUS -> QuestionIdModelEnum.SEX_LIFE_COUNT_THREE_PLUS
            QuestionIdDomainEnum.SEX_LIFE_COUNT_TEN_PLUS -> QuestionIdModelEnum.SEX_LIFE_COUNT_TEN_PLUS
            QuestionIdDomainEnum.SEX_BELOW_AGE -> QuestionIdModelEnum.SEX_BELOW_AGE
            QuestionIdDomainEnum.SEX_ORAL -> QuestionIdModelEnum.SEX_ORAL
            QuestionIdDomainEnum.SEX_ANAL -> QuestionIdModelEnum.SEX_ANAL
            QuestionIdDomainEnum.SEX_VIRGIN_CHECKED -> QuestionIdModelEnum.SEX_VIRGIN_CHECKED
            QuestionIdDomainEnum.SEX_CONDOMLESS -> QuestionIdModelEnum.SEX_CONDOMLESS
            QuestionIdDomainEnum.SEX_TOYS -> QuestionIdModelEnum.SEX_TOYS
            QuestionIdDomainEnum.SEX_UPSIDE_DOWN -> QuestionIdModelEnum.SEX_UPSIDE_DOWN
            QuestionIdDomainEnum.SEX_PUBLIC -> QuestionIdModelEnum.SEX_PUBLIC
            QuestionIdDomainEnum.SEX_SHOPPING -> QuestionIdModelEnum.SEX_SHOPPING
            QuestionIdDomainEnum.SEX_MOVIE_THEATRE -> QuestionIdModelEnum.SEX_MOVIE_THEATRE
            QuestionIdDomainEnum.SEX_FOR_PUBLIC -> QuestionIdModelEnum.SEX_FOR_PUBLIC
            QuestionIdDomainEnum.SEX_FILMED -> QuestionIdModelEnum.SEX_FILMED
            QuestionIdDomainEnum.SEX_WITHOUT_CONSENT -> QuestionIdModelEnum.SEX_WITHOUT_CONSENT
            QuestionIdDomainEnum.SEX_ANIMAL -> QuestionIdModelEnum.SEX_ANIMAL
            QuestionIdDomainEnum.SEX_PLAT -> QuestionIdModelEnum.SEX_PLAT
            QuestionIdDomainEnum.SEX_ROOF -> QuestionIdModelEnum.SEX_ROOF
            QuestionIdDomainEnum.SEX_AQUEOUS -> QuestionIdModelEnum.SEX_AQUEOUS
            QuestionIdDomainEnum.SEX_NON_NEWTONIAN -> QuestionIdModelEnum.SEX_NON_NEWTONIAN
            QuestionIdDomainEnum.SEX_EAT_FOOD -> QuestionIdModelEnum.SEX_EAT_FOOD
            QuestionIdDomainEnum.SEX_SIX_NINE -> QuestionIdModelEnum.SEX_SIX_NINE
            QuestionIdDomainEnum.SEX_MULTIPLE_POSITIONS -> QuestionIdModelEnum.SEX_MULTIPLE_POSITIONS
            QuestionIdDomainEnum.SEX_HAMMOCK -> QuestionIdModelEnum.SEX_HAMMOCK
            QuestionIdDomainEnum.SEX_COLONOSCOPY -> QuestionIdModelEnum.SEX_COLONOSCOPY
            QuestionIdDomainEnum.SEX_MENSTRUATION -> QuestionIdModelEnum.SEX_MENSTRUATION
            QuestionIdDomainEnum.SEX_CLOWN -> QuestionIdModelEnum.SEX_CLOWN
            QuestionIdDomainEnum.SEX_SURPRISE_SLIP -> QuestionIdModelEnum.SEX_SURPRISE_SLIP
            QuestionIdDomainEnum.SEX_EXCRETA -> QuestionIdModelEnum.SEX_EXCRETA
            QuestionIdDomainEnum.SEX_BUTT_WASHER -> QuestionIdModelEnum.SEX_BUTT_WASHER
            QuestionIdDomainEnum.SEX_COSTUME -> QuestionIdModelEnum.SEX_COSTUME
            else -> QuestionIdModelEnum.INVALID
        }

    override fun mapIdToPurityModel(id: QuestionIdDomainEnum): QuestionIdModelEnum =
        when (id) {
            QuestionIdDomainEnum.PURITY_SEEKER_TODO -> QuestionIdModelEnum.PURITY_SEEKER_TODO
            else -> QuestionIdModelEnum.INVALID
        }
}
