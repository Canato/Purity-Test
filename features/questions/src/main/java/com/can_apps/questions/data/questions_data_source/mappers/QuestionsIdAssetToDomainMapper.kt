package com.can_apps.questions.data.questions_data_source.mappers

import com.can_apps.questions.core.QuestionIdDomainEnum

internal interface QuestionsIdAssetToDomainMapper {
    fun mapIdToBanditryDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToMakeOutDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToNervousMouthDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToMasturbationDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToSinsDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToExhibitionismDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToCrazyLifeDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToLegalDrugsDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToIllegalDrugsDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToUniFeelingsDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToSexDomain(id: Int): QuestionIdDomainEnum
    fun mapIdToPurityDomain(id: Int): QuestionIdDomainEnum
}

internal class QuestionsIdAssetToDomainMapperDefault() : QuestionsIdAssetToDomainMapper {

    override fun mapIdToBanditryDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            1001 -> QuestionIdDomainEnum.BANDITRY_POLICE
            1002 -> QuestionIdDomainEnum.BANDITRY_DRIVE_DRUNK
            1003 -> QuestionIdDomainEnum.BANDITRY_LOST_LICENCE
            1004 -> QuestionIdDomainEnum.BANDITRY_ACCUSED
            1005 -> QuestionIdDomainEnum.BANDITRY_JUVENILE
            1006 -> QuestionIdDomainEnum.BANDITRY_STEALING
            1007 -> QuestionIdDomainEnum.BANDITRY_SOLD_STOLEN
            1008 -> QuestionIdDomainEnum.BANDITRY_BOUGHT_STOLEN
            1009 -> QuestionIdDomainEnum.BANDITRY_NOTION
            1010 -> QuestionIdDomainEnum.BANDITRY_PREGNANT
            1011 -> QuestionIdDomainEnum.BANDITRY_ABORTION
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToMakeOutDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            2001 -> QuestionIdDomainEnum.MAKE_OUT_NIGHT_PARTY
            2002 -> QuestionIdDomainEnum.MAKE_OUT_WITH_PERSON
            2003 -> QuestionIdDomainEnum.MAKE_OUT_WITH_SAME_GENDER
            2004 -> QuestionIdDomainEnum.MAKE_OUT_ONE_UNKNOWN
            2005 -> QuestionIdDomainEnum.MAKE_OUT_THREE
            2006 -> QuestionIdDomainEnum.MAKE_OUT_HARD
            2007 -> QuestionIdDomainEnum.MAKE_OUT_HARD_DRIVING
            2008 -> QuestionIdDomainEnum.MAKE_OUT_TCHACA
            2009 -> QuestionIdDomainEnum.MAKE_OUT_TOUCH_BREAST
            2010 -> QuestionIdDomainEnum.MAKE_OUT_TOUCH_ASS
            2011 -> QuestionIdDomainEnum.MAKE_OUT_TOUCH_GENITALS
            2012 -> QuestionIdDomainEnum.MAKE_OUT_MOUTH_BREAST
            2013 -> QuestionIdDomainEnum.MAKE_OUT_MOUTH_GENITALS
            2014 -> QuestionIdDomainEnum.MAKE_OUT_MOUTH_SAME_GENDER
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToNervousMouthDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            3001 -> QuestionIdDomainEnum.NERVOUS_MOUTH_WITHOUT_TONGUE
            3002 -> QuestionIdDomainEnum.NERVOUS_MOUTH_WITH_TONGUE
            3003 -> QuestionIdDomainEnum.NERVOUS_MOUTH_OPPOSITE_GENDER
            3004 -> QuestionIdDomainEnum.NERVOUS_MOUTH_SAME_GENDER
            3005 -> QuestionIdDomainEnum.NERVOUS_MOUTH_MORE_THAN_ONE
            3006 -> QuestionIdDomainEnum.NERVOUS_MOUTH_MORE_THAN_ONE_OPPOSITE
            3007 -> QuestionIdDomainEnum.NERVOUS_MOUTH_MORE_THAN_ONE_SAME
            3008 -> QuestionIdDomainEnum.NERVOUS_MOUTH_EAR
            3009 -> QuestionIdDomainEnum.NERVOUS_MOUTH_NECK
            3010 -> QuestionIdDomainEnum.NERVOUS_MOUTH_SHOULDER
            3011 -> QuestionIdDomainEnum.NERVOUS_MOUTH_WAIST
            3012 -> QuestionIdDomainEnum.NERVOUS_MOUTH_GENITALS
            3013 -> QuestionIdDomainEnum.NERVOUS_MOUTH_GAME_KISS
            3014 -> QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_TRIPLE
            3015 -> QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_QUADRUPLE
            3016 -> QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_MORE
            3017 -> QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_GREEK
            3018 -> QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_FRANCO_GREEK
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToMasturbationDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            4001 -> QuestionIdDomainEnum.MASTURBATION_SOLO
            4002 -> QuestionIdDomainEnum.MASTURBATION_TWO_MORE
            4003 -> QuestionIdDomainEnum.MASTURBATION_PHONE
            4004 -> QuestionIdDomainEnum.MASTURBATION_VIDEO_CALL
            4005 -> QuestionIdDomainEnum.MASTURBATION_OBJECT
            4006 -> QuestionIdDomainEnum.MASTURBATION_FOOD
            4007 -> QuestionIdDomainEnum.MASTURBATION_GIVEN
            4008 -> QuestionIdDomainEnum.MASTURBATION_TAKEN
            4009 -> QuestionIdDomainEnum.MASTURBATION_CAUGHT
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToSinsDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            5001 -> QuestionIdDomainEnum.SINS_GLUTTONY
            5002 -> QuestionIdDomainEnum.SINS_GREED
            5003 -> QuestionIdDomainEnum.SINS_LUST
            5004 -> QuestionIdDomainEnum.SINS_WRATH
            5005 -> QuestionIdDomainEnum.SINS_ENVY
            5006 -> QuestionIdDomainEnum.SINS_SLOTH
            5007 -> QuestionIdDomainEnum.SINS_PRIDE
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToExhibitionismDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            6001 -> QuestionIdDomainEnum.EXHIBITIONISM_SEXUAL_ACTION
            6002 -> QuestionIdDomainEnum.EXHIBITIONISM_SWIM
            6003 -> QuestionIdDomainEnum.EXHIBITIONISM_RUN
            6004 -> QuestionIdDomainEnum.EXHIBITIONISM_XEROX
            6005 -> QuestionIdDomainEnum.EXHIBITIONISM_SEX_CLOTHES
            6006 -> QuestionIdDomainEnum.EXHIBITIONISM_FLASHING
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToCrazyLifeDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            7001 -> QuestionIdDomainEnum.CRAZY_LIFE_ORGY
            7002 -> QuestionIdDomainEnum.CRAZY_LIFE_ORGASM
            7003 -> QuestionIdDomainEnum.CRAZY_LIFE_HIDE
            7004 -> QuestionIdDomainEnum.CRAZY_LIFE_HIDE_SEX
            7005 -> QuestionIdDomainEnum.CRAZY_LIFE_KISS_PROSTITUTE
            7006 -> QuestionIdDomainEnum.CRAZY_LIFE_POLE_DANCE
            7007 -> QuestionIdDomainEnum.CRAZY_LIFE_STRIPPER
            7008 -> QuestionIdDomainEnum.CRAZY_LIFE_WIN_MONEY
            7009 -> QuestionIdDomainEnum.CRAZY_LIFE_PAID_SEX
            7010 -> QuestionIdDomainEnum.CRAZY_LIFE_PAID_BODY
            7011 -> QuestionIdDomainEnum.CRAZY_LIFE_CHEAT
            7012 -> QuestionIdDomainEnum.CRAZY_LIFE_JIGLYPUFF
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToLegalDrugsDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            8001 -> QuestionIdDomainEnum.LEGAL_DRUGS_LOT_GOOD
            8002 -> QuestionIdDomainEnum.LEGAL_DRUGS_THREE_TOGETHER
            8003 -> QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_VOMIT
            8004 -> QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_FALL
            8005 -> QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_PEE
            8006 -> QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_FAINT
            8007 -> QuestionIdDomainEnum.LEGAL_DRUGS_HOSPITAL
            8008 -> QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_COMA
            8009 -> QuestionIdDomainEnum.LEGAL_DRUGS_BE_CRAZY
            8010 -> QuestionIdDomainEnum.LEGAL_DRUGS_TO_FORGET
            8011 -> QuestionIdDomainEnum.LEGAL_DRUGS_TO_THROW_UP
            8012 -> QuestionIdDomainEnum.LEGAL_DRUGS_SEX_SOMEONE
            8013 -> QuestionIdDomainEnum.LEGAL_DRUGS_SEX_YOURSELF
            8014 -> QuestionIdDomainEnum.LEGAL_DRUGS_BLACKOUT
            8015 -> QuestionIdDomainEnum.LEGAL_DRUGS_BLACKOUT_SEX
            8016 -> QuestionIdDomainEnum.LEGAL_DRUGS_CIGARETS
            8017 -> QuestionIdDomainEnum.LEGAL_DRUGS_THREE_PER_DAY
            8018 -> QuestionIdDomainEnum.LEGAL_DRUGS_PACK_ONE_PLUS
            8019 -> QuestionIdDomainEnum.LEGAL_DRUGS_SMOKE_ORGANIC
            8020 -> QuestionIdDomainEnum.LEGAL_DRUGS_SMOKE_SHISHA
            8021 -> QuestionIdDomainEnum.LEGAL_DRUGS_MEDICINE
            8022 -> QuestionIdDomainEnum.LEGAL_DRUGS_BLACK_STRIPE
            8023 -> QuestionIdDomainEnum.LEGAL_DRUGS_OWN_BREW
            8024 -> QuestionIdDomainEnum.LEGAL_DRUGS_BODY_SHOT
            8025 -> QuestionIdDomainEnum.LEGAL_DRUGS_DRINK_FLOOR
            8026 -> QuestionIdDomainEnum.LEGAL_DRUGS_SLEPT_VOMIT
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToIllegalDrugsDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            9001 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_ILLICIT
            9002 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_ONE_PLUS
            9003 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_TWO_PLUS
            9004 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_FIVE_PLUS
            9005 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_SYNTHETIC
            9006 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_SHARE
            9007 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_SELL
            9008 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_BUY
            9009 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_CULTIVATE
            9010 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_PLANT
            9011 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_COCAINE
            9012 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_BLACK_OUT
            9013 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_SYNTHETIC_EXTEND
            9014 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_CANCELLING
            9015 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_COOKING
            9016 -> QuestionIdDomainEnum.ILLEGAL_DRUGS_FORGETTING
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToUniFeelingsDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            10001 -> QuestionIdDomainEnum.UNI_FEELINGS_WEEKEND_PARTY_ONCE
            10002 -> QuestionIdDomainEnum.UNI_FEELINGS_WEEKEND_PARTY_TWO_PLUS
            10003 -> QuestionIdDomainEnum.UNI_FEELINGS_WEEKEND_PARTY_FIVE_PLUS
            10004 -> QuestionIdDomainEnum.UNI_FEELINGS_SEX_UNI
            10005 -> QuestionIdDomainEnum.UNI_FEELINGS_SEX_CAFETERIA
            10006 -> QuestionIdDomainEnum.UNI_FEELINGS_SEX_LIBRARY
            10007 -> QuestionIdDomainEnum.UNI_FEELINGS_SEX_LAB
            10008 -> QuestionIdDomainEnum.UNI_FEELINGS_SEX_STUDENT_CENTER
            10009 -> QuestionIdDomainEnum.UNI_FEELINGS_SEX_MAIN_ROOM
            10010 -> QuestionIdDomainEnum.UNI_FEELINGS_DANCE_TABLE
            10011 -> QuestionIdDomainEnum.UNI_FEELINGS_DANCE_TABLE_UNDERWEAR
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToSexDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            12001 -> QuestionIdDomainEnum.SEX_HAD
            12002 -> QuestionIdDomainEnum.SEX_BORED
            12003 -> QuestionIdDomainEnum.SEX_KNOWN_SHORT
            12004 -> QuestionIdDomainEnum.SEX_SLEPT_DURING
            12005 -> QuestionIdDomainEnum.SEX_SLEPT_EXTRA
            12006 -> QuestionIdDomainEnum.SEX_SLEPT_EXTRA_SAME_BED
            12007 -> QuestionIdDomainEnum.SEX_SAME_FAMILY
            12008 -> QuestionIdDomainEnum.SEX_MILF
            12009 -> QuestionIdDomainEnum.SEX_PREGNANCY
            12010 -> QuestionIdDomainEnum.SEX_THREESOME
            12011 -> QuestionIdDomainEnum.SEX_THREESOME_TWO_WOMAN
            12012 -> QuestionIdDomainEnum.SEX_THREESOME_TWO_MAN
            12013 -> QuestionIdDomainEnum.SEX_ORGY
            12014 -> QuestionIdDomainEnum.SEX_SWING
            12015 -> QuestionIdDomainEnum.SEX_SAME_NIGHT_TRIPLE
            12016 -> QuestionIdDomainEnum.SEX_LIFE_COUNT_THREE_PLUS
            12017 -> QuestionIdDomainEnum.SEX_LIFE_COUNT_TEN_PLUS
            12018 -> QuestionIdDomainEnum.SEX_BELOW_AGE
            12019 -> QuestionIdDomainEnum.SEX_ORAL
            12020 -> QuestionIdDomainEnum.SEX_ANAL
            12021 -> QuestionIdDomainEnum.SEX_VIRGIN_CHECKED
            12022 -> QuestionIdDomainEnum.SEX_CONDOMLESS
            12023 -> QuestionIdDomainEnum.SEX_TOYS
            12024 -> QuestionIdDomainEnum.SEX_UPSIDE_DOWN
            12025 -> QuestionIdDomainEnum.SEX_PUBLIC
            12026 -> QuestionIdDomainEnum.SEX_SHOPPING
            12027 -> QuestionIdDomainEnum.SEX_MOVIE_THEATRE
            12028 -> QuestionIdDomainEnum.SEX_FOR_PUBLIC
            12029 -> QuestionIdDomainEnum.SEX_FILMED
            12030 -> QuestionIdDomainEnum.SEX_WITHOUT_CONSENT
            12031 -> QuestionIdDomainEnum.SEX_ANIMAL
            12032 -> QuestionIdDomainEnum.SEX_PLAT
            12033 -> QuestionIdDomainEnum.SEX_ROOF
            12034 -> QuestionIdDomainEnum.SEX_AQUEOUS
            12035 -> QuestionIdDomainEnum.SEX_NON_NEWTONIAN
            12036 -> QuestionIdDomainEnum.SEX_EAT_FOOD
            12037 -> QuestionIdDomainEnum.SEX_SIX_NINE
            12038 -> QuestionIdDomainEnum.SEX_MULTIPLE_POSITIONS
            12039 -> QuestionIdDomainEnum.SEX_HAMMOCK
            12040 -> QuestionIdDomainEnum.SEX_COLONOSCOPY
            12041 -> QuestionIdDomainEnum.SEX_MENSTRUATION
            12042 -> QuestionIdDomainEnum.SEX_CLOWN
            12043 -> QuestionIdDomainEnum.SEX_SURPRISE_SLIP
            12044 -> QuestionIdDomainEnum.SEX_EXCRETA
            12045 -> QuestionIdDomainEnum.SEX_BUTT_WASHER
            12046 -> QuestionIdDomainEnum.SEX_COSTUME
            else -> QuestionIdDomainEnum.INVALID
        }

    override fun mapIdToPurityDomain(id: Int): QuestionIdDomainEnum =
        when (id) {
            99901 -> QuestionIdDomainEnum.PURITY_SEEKER_TODO
            else -> QuestionIdDomainEnum.INVALID
        }
}
