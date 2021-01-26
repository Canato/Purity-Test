package com.can_apps.questions.data.mappers

import com.can_apps.questions.core.QuestionIdDomainEnum
import com.can_apps.questions.data.questions_data_source.mappers.QuestionsIdAssetToDomainMapperDefault
import org.junit.Assert
import org.junit.Test

internal class QuestionsIdAssetToDomainMapperDefaultTest {

    private val idDomainMapper = QuestionsIdAssetToDomainMapperDefault()

    @Test
    fun `GIVEN id, WHEN mapIdToBanditryDomain, THEN return QuestionIdDomainEnum_BANDITRY_id`() {
        // GIVEN
        val id = listOf(666, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011)
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.BANDITRY_POLICE,
            QuestionIdDomainEnum.BANDITRY_DRIVE_DRUNK,
            QuestionIdDomainEnum.BANDITRY_LOST_LICENCE,
            QuestionIdDomainEnum.BANDITRY_ACCUSED,
            QuestionIdDomainEnum.BANDITRY_JUVENILE,
            QuestionIdDomainEnum.BANDITRY_STEALING,
            QuestionIdDomainEnum.BANDITRY_SOLD_STOLEN,
            QuestionIdDomainEnum.BANDITRY_BOUGHT_STOLEN,
            QuestionIdDomainEnum.BANDITRY_NOTION,
            QuestionIdDomainEnum.BANDITRY_PREGNANT,
            QuestionIdDomainEnum.BANDITRY_ABORTION
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToBanditryDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToMakeOutDomain, THEN return QuestionIdDomainEnum_MAKE_OUT_id`() {
        // GIVEN
        val id = listOf(
            666, 2001, 2002, 2003, 2004, 2005, 2006, 2007,
            2008, 2009, 2010, 2011, 2012, 2013, 2014
        )
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.MAKE_OUT_NIGHT_PARTY,
            QuestionIdDomainEnum.MAKE_OUT_WITH_PERSON,
            QuestionIdDomainEnum.MAKE_OUT_WITH_SAME_GENDER,
            QuestionIdDomainEnum.MAKE_OUT_ONE_UNKNOWN,
            QuestionIdDomainEnum.MAKE_OUT_THREE,
            QuestionIdDomainEnum.MAKE_OUT_HARD,
            QuestionIdDomainEnum.MAKE_OUT_HARD_DRIVING,
            QuestionIdDomainEnum.MAKE_OUT_TCHACA,
            QuestionIdDomainEnum.MAKE_OUT_TOUCH_BREAST,
            QuestionIdDomainEnum.MAKE_OUT_TOUCH_ASS,
            QuestionIdDomainEnum.MAKE_OUT_TOUCH_GENITALS,
            QuestionIdDomainEnum.MAKE_OUT_MOUTH_BREAST,
            QuestionIdDomainEnum.MAKE_OUT_MOUTH_GENITALS,
            QuestionIdDomainEnum.MAKE_OUT_MOUTH_SAME_GENDER
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToMakeOutDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToNervousMouthDomain, THEN return QuestionIdDomainEnum_NERVOUS_MOUTH_id`() {
        // GIVEN
        val id = listOf(
            666,
            3001, 3002, 3003, 3004, 3005, 3006, 3007, 3008, 3009,
            3010, 3011, 3012, 3013, 3014, 3015, 3016, 3017, 3018
        )
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.NERVOUS_MOUTH_WITHOUT_TONGUE,
            QuestionIdDomainEnum.NERVOUS_MOUTH_WITH_TONGUE,
            QuestionIdDomainEnum.NERVOUS_MOUTH_OPPOSITE_GENDER,
            QuestionIdDomainEnum.NERVOUS_MOUTH_SAME_GENDER,
            QuestionIdDomainEnum.NERVOUS_MOUTH_MORE_THAN_ONE,
            QuestionIdDomainEnum.NERVOUS_MOUTH_MORE_THAN_ONE_OPPOSITE,
            QuestionIdDomainEnum.NERVOUS_MOUTH_MORE_THAN_ONE_SAME,
            QuestionIdDomainEnum.NERVOUS_MOUTH_EAR,
            QuestionIdDomainEnum.NERVOUS_MOUTH_NECK,
            QuestionIdDomainEnum.NERVOUS_MOUTH_SHOULDER,
            QuestionIdDomainEnum.NERVOUS_MOUTH_WAIST,
            QuestionIdDomainEnum.NERVOUS_MOUTH_GENITALS,
            QuestionIdDomainEnum.NERVOUS_MOUTH_GAME_KISS,
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_TRIPLE,
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_QUADRUPLE,
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_MORE,
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_GREEK,
            QuestionIdDomainEnum.NERVOUS_MOUTH_KISS_FRANCO_GREEK
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToNervousMouthDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToMasturbationDomain, THEN return QuestionIdDomainEnum_MASTURBATION_id`() {
        // GIVEN
        val id = listOf(
            666,
            4001,
            4002,
            4003,
            4004,
            4005,
            4006,
            4007,
            4008,
            4009
        )
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.MASTURBATION_SOLO,
            QuestionIdDomainEnum.MASTURBATION_TWO_MORE,
            QuestionIdDomainEnum.MASTURBATION_PHONE,
            QuestionIdDomainEnum.MASTURBATION_VIDEO_CALL,
            QuestionIdDomainEnum.MASTURBATION_OBJECT,
            QuestionIdDomainEnum.MASTURBATION_FOOD,
            QuestionIdDomainEnum.MASTURBATION_GIVEN,
            QuestionIdDomainEnum.MASTURBATION_TAKEN,
            QuestionIdDomainEnum.MASTURBATION_CAUGHT
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToMasturbationDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToSinsDomain, THEN return QuestionIdDomainEnum_SINS_id`() {
        // GIVEN
        val id = listOf(666, 5001, 5002, 5003, 5004, 5005, 5006, 5007)
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.SINS_GLUTTONY,
            QuestionIdDomainEnum.SINS_GREED,
            QuestionIdDomainEnum.SINS_LUST,
            QuestionIdDomainEnum.SINS_WRATH,
            QuestionIdDomainEnum.SINS_ENVY,
            QuestionIdDomainEnum.SINS_SLOTH,
            QuestionIdDomainEnum.SINS_PRIDE
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToSinsDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToExhibitionDomain, THEN return QuestionIdDomainEnum_EXHIBITION_id`() {
        // GIVEN
        val id = listOf(666, 6001, 6002, 6003, 6004, 6005, 6006)
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.EXHIBITIONISM_SEXUAL_ACTION,
            QuestionIdDomainEnum.EXHIBITIONISM_SWIM,
            QuestionIdDomainEnum.EXHIBITIONISM_RUN,
            QuestionIdDomainEnum.EXHIBITIONISM_XEROX,
            QuestionIdDomainEnum.EXHIBITIONISM_SEX_CLOTHES,
            QuestionIdDomainEnum.EXHIBITIONISM_FLASHING
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToExhibitionismDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToCrazyLifeDomain, THEN return QuestionIdDomainEnum_CRAZY_LIFE_id`() {
        // GIVEN
        val id = listOf(
            666, 7001, 7002, 7003, 7004,
            7005, 7006, 7007, 7008, 7009, 7010, 7011, 7012
        )
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.CRAZY_LIFE_ORGY,
            QuestionIdDomainEnum.CRAZY_LIFE_ORGASM,
            QuestionIdDomainEnum.CRAZY_LIFE_HIDE,
            QuestionIdDomainEnum.CRAZY_LIFE_HIDE_SEX,
            QuestionIdDomainEnum.CRAZY_LIFE_KISS_PROSTITUTE,
            QuestionIdDomainEnum.CRAZY_LIFE_POLE_DANCE,
            QuestionIdDomainEnum.CRAZY_LIFE_STRIPPER,
            QuestionIdDomainEnum.CRAZY_LIFE_WIN_MONEY,
            QuestionIdDomainEnum.CRAZY_LIFE_PAID_SEX,
            QuestionIdDomainEnum.CRAZY_LIFE_PAID_BODY,
            QuestionIdDomainEnum.CRAZY_LIFE_CHEAT,
            QuestionIdDomainEnum.CRAZY_LIFE_JIGLYPUFF
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToCrazyLifeDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToLegalDrugsDomain, THEN return QuestionIdDomainEnum_LEGAL_DRUGS_id`() {
        // GIVEN
        val id = listOf(
            666,
            8001, 8002, 8003, 8004, 8005, 8006, 8007, 8008, 8009,
            8010, 8011, 8012, 8013, 8014, 8015, 8016, 8017, 8018, 8019,
            8020, 8021, 8022, 8023, 8024, 8025, 8026
        )
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.LEGAL_DRUGS_LOT_GOOD,
            QuestionIdDomainEnum.LEGAL_DRUGS_THREE_TOGETHER,
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_VOMIT,
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_FALL,
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_PEE,
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_FAINT,
            QuestionIdDomainEnum.LEGAL_DRUGS_HOSPITAL,
            QuestionIdDomainEnum.LEGAL_DRUGS_UNTIL_COMA,
            QuestionIdDomainEnum.LEGAL_DRUGS_BE_CRAZY,
            QuestionIdDomainEnum.LEGAL_DRUGS_TO_FORGET,
            QuestionIdDomainEnum.LEGAL_DRUGS_TO_THROW_UP,
            QuestionIdDomainEnum.LEGAL_DRUGS_SEX_SOMEONE,
            QuestionIdDomainEnum.LEGAL_DRUGS_SEX_YOURSELF,
            QuestionIdDomainEnum.LEGAL_DRUGS_BLACKOUT,
            QuestionIdDomainEnum.LEGAL_DRUGS_BLACKOUT_SEX,
            QuestionIdDomainEnum.LEGAL_DRUGS_CIGARETS,
            QuestionIdDomainEnum.LEGAL_DRUGS_THREE_PER_DAY,
            QuestionIdDomainEnum.LEGAL_DRUGS_PACK_ONE_PLUS,
            QuestionIdDomainEnum.LEGAL_DRUGS_SMOKE_ORGANIC,
            QuestionIdDomainEnum.LEGAL_DRUGS_SMOKE_SHISHA,
            QuestionIdDomainEnum.LEGAL_DRUGS_MEDICINE,
            QuestionIdDomainEnum.LEGAL_DRUGS_BLACK_STRIPE,
            QuestionIdDomainEnum.LEGAL_DRUGS_OWN_BREW,
            QuestionIdDomainEnum.LEGAL_DRUGS_BODY_SHOT,
            QuestionIdDomainEnum.LEGAL_DRUGS_DRINK_FLOOR,
            QuestionIdDomainEnum.LEGAL_DRUGS_SLEPT_VOMIT
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToLegalDrugsDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToIllegalDrugsDomain, THEN return QuestionIdDomainEnum_ILLEGAL_DRUGS_id`() {
        // GIVEN
        val id = listOf(
            666,
            9001, 9002, 9003, 9004, 9005, 9006, 9007, 9008,
            9009, 9010, 9011, 9012, 9013, 9014, 9015, 9016
        )
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_ILLICIT,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_ONE_PLUS,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_TWO_PLUS,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_FIVE_PLUS,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_SYNTHETIC,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_SHARE,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_SELL,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_BUY,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_CULTIVATE,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_PLANT,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_COCAINE,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_BLACK_OUT,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_SYNTHETIC_EXTEND,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_CANCELLING,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_COOKING,
            QuestionIdDomainEnum.ILLEGAL_DRUGS_FORGETTING
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToIllegalDrugsDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToUniFeelingDomain, THEN return QuestionIdDomainEnum_UNI_FEELINGS_id`() {
        // GIVEN
        val id = listOf(
            666,
            10001,
            10002,
            10003,
            10004,
            10005,
            10006,
            10007,
            10008,
            10009,
            10010,
            10011
        )
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.UNI_FEELINGS_WEEKEND_PARTY_ONCE,
            QuestionIdDomainEnum.UNI_FEELINGS_WEEKEND_PARTY_TWO_PLUS,
            QuestionIdDomainEnum.UNI_FEELINGS_WEEKEND_PARTY_FIVE_PLUS,
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_UNI,
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_CAFETERIA,
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_LIBRARY,
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_LAB,
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_STUDENT_CENTER,
            QuestionIdDomainEnum.UNI_FEELINGS_SEX_MAIN_ROOM,
            QuestionIdDomainEnum.UNI_FEELINGS_DANCE_TABLE,
            QuestionIdDomainEnum.UNI_FEELINGS_DANCE_TABLE_UNDERWEAR
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToUniFeelingsDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToSexDomain, THEN return QuestionIdDomainEnum_SEX_id`() {
        // GIVEN
        val id = listOf(
            666,
            12001,
            12002,
            12003,
            12004,
            12005,
            12006,
            12007,
            12008,
            12009,
            12010,
            12011,
            12012,
            12013,
            12014,
            12015,
            12016,
            12017,
            12018,
            12019,
            12020,
            12021,
            12022,
            12023,
            12024,
            12025,
            12026,
            12027,
            12028,
            12029,
            12030,
            12031,
            12032,
            12033,
            12034,
            12035,
            12036,
            12037,
            12038,
            12039,
            12040,
            12041,
            12042,
            12043,
            12044,
            12045,
            12046
        )
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.SEX_HAD,
            QuestionIdDomainEnum.SEX_BORED,
            QuestionIdDomainEnum.SEX_KNOWN_SHORT,
            QuestionIdDomainEnum.SEX_SLEPT_DURING,
            QuestionIdDomainEnum.SEX_SLEPT_EXTRA,
            QuestionIdDomainEnum.SEX_SLEPT_EXTRA_SAME_BED,
            QuestionIdDomainEnum.SEX_SAME_FAMILY,
            QuestionIdDomainEnum.SEX_MILF,
            QuestionIdDomainEnum.SEX_PREGNANCY,
            QuestionIdDomainEnum.SEX_THREESOME,
            QuestionIdDomainEnum.SEX_THREESOME_TWO_WOMAN,
            QuestionIdDomainEnum.SEX_THREESOME_TWO_MAN,
            QuestionIdDomainEnum.SEX_ORGY,
            QuestionIdDomainEnum.SEX_SWING,
            QuestionIdDomainEnum.SEX_SAME_NIGHT_TRIPLE,
            QuestionIdDomainEnum.SEX_LIFE_COUNT_THREE_PLUS,
            QuestionIdDomainEnum.SEX_LIFE_COUNT_TEN_PLUS,
            QuestionIdDomainEnum.SEX_BELOW_AGE,
            QuestionIdDomainEnum.SEX_ORAL,
            QuestionIdDomainEnum.SEX_ANAL,
            QuestionIdDomainEnum.SEX_VIRGIN_CHECKED,
            QuestionIdDomainEnum.SEX_CONDOMLESS,
            QuestionIdDomainEnum.SEX_TOYS,
            QuestionIdDomainEnum.SEX_UPSIDE_DOWN,
            QuestionIdDomainEnum.SEX_PUBLIC,
            QuestionIdDomainEnum.SEX_SHOPPING,
            QuestionIdDomainEnum.SEX_MOVIE_THEATRE,
            QuestionIdDomainEnum.SEX_FOR_PUBLIC,
            QuestionIdDomainEnum.SEX_FILMED,
            QuestionIdDomainEnum.SEX_WITHOUT_CONSENT,
            QuestionIdDomainEnum.SEX_ANIMAL,
            QuestionIdDomainEnum.SEX_PLAT,
            QuestionIdDomainEnum.SEX_ROOF,
            QuestionIdDomainEnum.SEX_AQUEOUS,
            QuestionIdDomainEnum.SEX_NON_NEWTONIAN,
            QuestionIdDomainEnum.SEX_EAT_FOOD,
            QuestionIdDomainEnum.SEX_SIX_NINE,
            QuestionIdDomainEnum.SEX_MULTIPLE_POSITIONS,
            QuestionIdDomainEnum.SEX_HAMMOCK,
            QuestionIdDomainEnum.SEX_COLONOSCOPY,
            QuestionIdDomainEnum.SEX_MENSTRUATION,
            QuestionIdDomainEnum.SEX_CLOWN,
            QuestionIdDomainEnum.SEX_SURPRISE_SLIP,
            QuestionIdDomainEnum.SEX_EXCRETA,
            QuestionIdDomainEnum.SEX_BUTT_WASHER,
            QuestionIdDomainEnum.SEX_COSTUME
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToSexDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN id, WHEN mapIdToPurityDomain, THEN return QuestionIdDomainEnum_PURITY_SEEKER_id`() {
        // GIVEN
        val id = listOf(666, 99901)
        val expected = listOf(
            QuestionIdDomainEnum.INVALID,
            QuestionIdDomainEnum.PURITY_SEEKER_TODO
        )

        // WHEN
        val result = id.map { idDomainMapper.mapIdToPurityDomain(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
