package com.can_apps.questions.bresenter.mappers

import com.can_apps.common.CommonStringResourceWrapper
import com.can_apps.questions.R
import com.can_apps.questions.bresenter.QuestionIdModelEnum
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class QuestionsTextModelStringMapperDefaultTest {

    @MockK
    private lateinit var stringResourceWrapper: CommonStringResourceWrapper

    @InjectMockKs
    private lateinit var textStringMapper: QuestionsTextModelStringMapperDefault

    @Before
    fun setup() = MockKAnnotations.init(this, relaxed = true)

    @Test
    fun `GIVEN idModelEnum, WHEN mapBanditryEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.BANDITRY_POLICE,
            QuestionIdModelEnum.BANDITRY_DRIVE_DRUNK,
            QuestionIdModelEnum.BANDITRY_LOST_LICENCE,
            QuestionIdModelEnum.BANDITRY_ACCUSED,
            QuestionIdModelEnum.BANDITRY_JUVENILE,
            QuestionIdModelEnum.BANDITRY_STEALING,
            QuestionIdModelEnum.BANDITRY_SOLD_STOLEN,
            QuestionIdModelEnum.BANDITRY_BOUGHT_STOLEN,
            QuestionIdModelEnum.BANDITRY_NOTION,
            QuestionIdModelEnum.BANDITRY_PREGNANT,
            QuestionIdModelEnum.BANDITRY_ABORTION
        )
        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question",
                "are",
                "you",
                "fine",
                "finally"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9],
            stringResourceValue[10],
            stringResourceValue[11]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.banditry_police) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.banditry_drive_drunk) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.banditry_lost_licence) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.banditry_accused) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.banditry_juvenile) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.banditry_stealing) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.banditry_sold_stolen) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.banditry_bought_stolen) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.banditry_notion) } returns stringResourceValue[9]
        every { stringResourceWrapper.getString(R.string.banditry_pregnant) } returns stringResourceValue[10]
        every { stringResourceWrapper.getString(R.string.banditry_abortion) } returns stringResourceValue[11]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapBanditryEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapMakeOutEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.MAKE_OUT_NIGHT_PARTY,
            QuestionIdModelEnum.MAKE_OUT_WITH_PERSON,
            QuestionIdModelEnum.MAKE_OUT_WITH_SAME_GENDER,
            QuestionIdModelEnum.MAKE_OUT_ONE_UNKNOWN,
            QuestionIdModelEnum.MAKE_OUT_THREE,
            QuestionIdModelEnum.MAKE_OUT_HARD,
            QuestionIdModelEnum.MAKE_OUT_HARD_DRIVING,
            QuestionIdModelEnum.MAKE_OUT_TCHACA,
            QuestionIdModelEnum.MAKE_OUT_TOUCH_BREAST,
            QuestionIdModelEnum.MAKE_OUT_TOUCH_ASS,
            QuestionIdModelEnum.MAKE_OUT_TOUCH_GENITALS,
            QuestionIdModelEnum.MAKE_OUT_MOUTH_BREAST,
            QuestionIdModelEnum.MAKE_OUT_MOUTH_GENITALS,
            QuestionIdModelEnum.MAKE_OUT_MOUTH_SAME_GENDER
        )
        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question",
                "are",
                "you",
                "fine",
                "finally",
                "so",
                "figure",
                "it",
                "out"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9],
            stringResourceValue[10],
            stringResourceValue[11],
            stringResourceValue[12],
            stringResourceValue[13],
            stringResourceValue[14]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.make_out_night_party) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.make_out_with_person) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.make_out_with_same_gender) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.make_out_one_unknown) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.make_out_three) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.make_out_hard) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.make_out_hard_driving) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.make_out_tchaca) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.make_out_touch_breast) } returns stringResourceValue[9]
        every { stringResourceWrapper.getString(R.string.make_out_touch_ass) } returns stringResourceValue[10]
        every { stringResourceWrapper.getString(R.string.make_out_touch_genitals) } returns stringResourceValue[11]
        every { stringResourceWrapper.getString(R.string.make_out_mouth_breast) } returns stringResourceValue[12]
        every { stringResourceWrapper.getString(R.string.make_out_mouth_genitals) } returns stringResourceValue[13]
        every { stringResourceWrapper.getString(R.string.make_out_mouth_same_gender) } returns stringResourceValue[14]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapMakeOutEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapNervousMouthEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.NERVOUS_MOUTH_WITHOUT_TONGUE,
            QuestionIdModelEnum.NERVOUS_MOUTH_WITH_TONGUE,
            QuestionIdModelEnum.NERVOUS_MOUTH_OPPOSITE_GENDER,
            QuestionIdModelEnum.NERVOUS_MOUTH_SAME_GENDER,
            QuestionIdModelEnum.NERVOUS_MOUTH_MORE_THAN_ONE,
            QuestionIdModelEnum.NERVOUS_MOUTH_MORE_THAN_ONE_OPPOSITE,
            QuestionIdModelEnum.NERVOUS_MOUTH_MORE_THAN_ONE_SAME,
            QuestionIdModelEnum.NERVOUS_MOUTH_EAR,
            QuestionIdModelEnum.NERVOUS_MOUTH_NECK,
            QuestionIdModelEnum.NERVOUS_MOUTH_SHOULDER,
            QuestionIdModelEnum.NERVOUS_MOUTH_WAIST,
            QuestionIdModelEnum.NERVOUS_MOUTH_GENITALS,
            QuestionIdModelEnum.NERVOUS_MOUTH_GAME_KISS,
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_TRIPLE,
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_QUADRUPLE,
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_MORE,
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_GREEK,
            QuestionIdModelEnum.NERVOUS_MOUTH_KISS_FRANCO_GREEK
        )

        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question",
                "are",
                "you",
                "fine",
                "finally",
                "so",
                "figure",
                "it",
                "out",
                "still",
                "missing",
                "some",
                "extra",
                "fake",
                "strings"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9],
            stringResourceValue[10],
            stringResourceValue[11],
            stringResourceValue[12],
            stringResourceValue[13],
            stringResourceValue[14],
            stringResourceValue[15],
            stringResourceValue[16],
            stringResourceValue[17],
            stringResourceValue[18]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_without_tongue) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_with_tongue) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_opposite_gender) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_same_gender) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_more_than_one) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_more_than_one_opposite) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_more_than_one_same) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_ear) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_neck) } returns stringResourceValue[9]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_shoulder) } returns stringResourceValue[10]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_waist) } returns stringResourceValue[11]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_genitals) } returns stringResourceValue[12]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_game_kiss) } returns stringResourceValue[13]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_kiss_triple) } returns stringResourceValue[14]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_kiss_quadruple) } returns stringResourceValue[15]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_kiss_more) } returns stringResourceValue[16]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_kiss_greek) } returns stringResourceValue[17]
        every { stringResourceWrapper.getString(R.string.nervous_mouth_kiss_franco_greek) } returns stringResourceValue[18]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapNervousMouthEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapMasturbationEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.MASTURBATION_SOLO,
            QuestionIdModelEnum.MASTURBATION_TWO_MORE,
            QuestionIdModelEnum.MASTURBATION_PHONE,
            QuestionIdModelEnum.MASTURBATION_VIDEO_CALL,
            QuestionIdModelEnum.MASTURBATION_OBJECT,
            QuestionIdModelEnum.MASTURBATION_FOOD,
            QuestionIdModelEnum.MASTURBATION_GIVEN,
            QuestionIdModelEnum.MASTURBATION_TAKEN,
            QuestionIdModelEnum.MASTURBATION_CAUGHT
        )
        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question",
                "are",
                "you"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.masturbation_solo) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.masturbation_two_more) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.masturbation_phone) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.masturbation_video_call) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.masturbation_object) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.masturbation_food) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.masturbation_given) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.masturbation_taken) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.masturbation_caught) } returns stringResourceValue[9]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapMasturbationEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapSinsEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.SINS_GLUTTONY,
            QuestionIdModelEnum.SINS_GREED,
            QuestionIdModelEnum.SINS_LUST,
            QuestionIdModelEnum.SINS_WRATH,
            QuestionIdModelEnum.SINS_ENVY,
            QuestionIdModelEnum.SINS_SLOTH,
            QuestionIdModelEnum.SINS_PRIDE
        )
        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.sins_gluttony) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.sins_greed) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.sins_lust) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.sins_wrath) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.sins_envy) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.sins_sloth) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.sins_pride) } returns stringResourceValue[7]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapSinsEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapExhibitionismEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.EXHIBITIONISM_SEXUAL_ACTION,
            QuestionIdModelEnum.EXHIBITIONISM_SWIM,
            QuestionIdModelEnum.EXHIBITIONISM_RUN,
            QuestionIdModelEnum.EXHIBITIONISM_XEROX,
            QuestionIdModelEnum.EXHIBITIONISM_SEX_CLOTHES,
            QuestionIdModelEnum.EXHIBITIONISM_FLASHING
        )
        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.exhibitionism_sexual_action) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.exhibitionism_swim) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.exhibitionism_run) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.exhibitionism_xerox) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.exhibitionism_sex_clothes) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.exhibitionism_flashing) } returns stringResourceValue[6]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapExhibitionismEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapCrazyLifeEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.CRAZY_LIFE_ORGY,
            QuestionIdModelEnum.CRAZY_LIFE_ORGASM,
            QuestionIdModelEnum.CRAZY_LIFE_HIDE,
            QuestionIdModelEnum.CRAZY_LIFE_HIDE_SEX,
            QuestionIdModelEnum.CRAZY_LIFE_KISS_PROSTITUTE,
            QuestionIdModelEnum.CRAZY_LIFE_POLE_DANCE,
            QuestionIdModelEnum.CRAZY_LIFE_STRIPPER,
            QuestionIdModelEnum.CRAZY_LIFE_WIN_MONEY,
            QuestionIdModelEnum.CRAZY_LIFE_PAID_SEX,
            QuestionIdModelEnum.CRAZY_LIFE_PAID_BODY,
            QuestionIdModelEnum.CRAZY_LIFE_CHEAT,
            QuestionIdModelEnum.CRAZY_LIFE_JIGLYPUFF
        )
        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question",
                "are",
                "you",
                "fine",
                "finally",
                "pefrect"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9],
            stringResourceValue[10],
            stringResourceValue[11],
            stringResourceValue[12]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.crazy_life_orgy) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.crazy_life_orgasm) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.crazy_life_hide) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.crazy_life_hide_sex) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.crazy_life_kiss_prostitute) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.crazy_life_pole_dance) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.crazy_life_stripper) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.crazy_life_win_money) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.crazy_life_paid_sex) } returns stringResourceValue[9]
        every { stringResourceWrapper.getString(R.string.crazy_life_paid_body) } returns stringResourceValue[10]
        every { stringResourceWrapper.getString(R.string.crazy_life_cheat) } returns stringResourceValue[11]
        every { stringResourceWrapper.getString(R.string.crazy_life_jiglypuff) } returns stringResourceValue[12]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapCrazyLifeEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapLegalDrugsEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.LEGAL_DRUGS_LOT_GOOD,
            QuestionIdModelEnum.LEGAL_DRUGS_THREE_TOGETHER,
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_VOMIT,
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_FALL,
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_PEE,
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_FAINT,
            QuestionIdModelEnum.LEGAL_DRUGS_HOSPITAL,
            QuestionIdModelEnum.LEGAL_DRUGS_UNTIL_COMA,
            QuestionIdModelEnum.LEGAL_DRUGS_BE_CRAZY,
            QuestionIdModelEnum.LEGAL_DRUGS_TO_FORGET,
            QuestionIdModelEnum.LEGAL_DRUGS_TO_THROW_UP,
            QuestionIdModelEnum.LEGAL_DRUGS_SEX_SOMEONE,
            QuestionIdModelEnum.LEGAL_DRUGS_SEX_YOURSELF,
            QuestionIdModelEnum.LEGAL_DRUGS_BLACKOUT,
            QuestionIdModelEnum.LEGAL_DRUGS_BLACKOUT_SEX,
            QuestionIdModelEnum.LEGAL_DRUGS_CIGARETS,
            QuestionIdModelEnum.LEGAL_DRUGS_THREE_PER_DAY,
            QuestionIdModelEnum.LEGAL_DRUGS_PACK_ONE_PLUS,
            QuestionIdModelEnum.LEGAL_DRUGS_SMOKE_ORGANIC,
            QuestionIdModelEnum.LEGAL_DRUGS_SMOKE_SHISHA,
            QuestionIdModelEnum.LEGAL_DRUGS_MEDICINE,
            QuestionIdModelEnum.LEGAL_DRUGS_BLACK_STRIPE,
            QuestionIdModelEnum.LEGAL_DRUGS_OWN_BREW,
            QuestionIdModelEnum.LEGAL_DRUGS_BODY_SHOT,
            QuestionIdModelEnum.LEGAL_DRUGS_DRINK_FLOOR,
            QuestionIdModelEnum.LEGAL_DRUGS_SLEPT_VOMIT
        )

        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question",
                "are",
                "you",
                "fine",
                "finally",
                "so",
                "figure",
                "it",
                "out",
                "still",
                "missing",
                "some",
                "extra",
                "fake",
                "strings",
                "how",
                "many",
                "elements",
                "I",
                "must",
                "invent",
                "darn"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9],
            stringResourceValue[10],
            stringResourceValue[11],
            stringResourceValue[12],
            stringResourceValue[13],
            stringResourceValue[14],
            stringResourceValue[15],
            stringResourceValue[16],
            stringResourceValue[17],
            stringResourceValue[18],
            stringResourceValue[19],
            stringResourceValue[20],
            stringResourceValue[21],
            stringResourceValue[22],
            stringResourceValue[23],
            stringResourceValue[24],
            stringResourceValue[25],
            stringResourceValue[26]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.legal_drugs_lot_good) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.legal_drugs_three_together) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.legal_drugs_until_vomit) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.legal_drugs_until_fall) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.legal_drugs_until_pee) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.legal_drugs_until_faint) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.legal_drugs_hospital) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.legal_drugs_until_coma) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.legal_drugs_be_crazy) } returns stringResourceValue[9]
        every { stringResourceWrapper.getString(R.string.legal_drugs_to_forget) } returns stringResourceValue[10]
        every { stringResourceWrapper.getString(R.string.legal_drugs_to_throw_up) } returns stringResourceValue[11]
        every { stringResourceWrapper.getString(R.string.legal_drugs_sex_someone) } returns stringResourceValue[12]
        every { stringResourceWrapper.getString(R.string.legal_drugs_sex_yourself) } returns stringResourceValue[13]
        every { stringResourceWrapper.getString(R.string.legal_drugs_blackout) } returns stringResourceValue[14]
        every { stringResourceWrapper.getString(R.string.legal_drugs_blackout_sex) } returns stringResourceValue[15]
        every { stringResourceWrapper.getString(R.string.legal_drugs_cigarets) } returns stringResourceValue[16]
        every { stringResourceWrapper.getString(R.string.legal_drugs_three_per_day) } returns stringResourceValue[17]
        every { stringResourceWrapper.getString(R.string.legal_drugs_pack_plus_one) } returns stringResourceValue[18]
        every { stringResourceWrapper.getString(R.string.legal_drugs_smoke_organic) } returns stringResourceValue[19]
        every { stringResourceWrapper.getString(R.string.legal_drugs_smoke_shisha) } returns stringResourceValue[20]
        every { stringResourceWrapper.getString(R.string.legal_drugs_medicine) } returns stringResourceValue[21]
        every { stringResourceWrapper.getString(R.string.legal_drugs_black_stripes) } returns stringResourceValue[22]
        every { stringResourceWrapper.getString(R.string.legal_drugs_own_brew) } returns stringResourceValue[23]
        every { stringResourceWrapper.getString(R.string.legal_drugs_body_shot) } returns stringResourceValue[24]
        every { stringResourceWrapper.getString(R.string.legal_drugs_drink_floor) } returns stringResourceValue[25]
        every { stringResourceWrapper.getString(R.string.legal_drugs_slept_vomit) } returns stringResourceValue[26]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapLegalDrugsEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapIllegalDrugsEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.ILLEGAL_DRUGS_ILLICIT,
            QuestionIdModelEnum.ILLEGAL_DRUGS_ONE_PLUS,
            QuestionIdModelEnum.ILLEGAL_DRUGS_TWO_PLUS,
            QuestionIdModelEnum.ILLEGAL_DRUGS_FIVE_PLUS,
            QuestionIdModelEnum.ILLEGAL_DRUGS_SYNTHETIC,
            QuestionIdModelEnum.ILLEGAL_DRUGS_SHARE,
            QuestionIdModelEnum.ILLEGAL_DRUGS_SELL,
            QuestionIdModelEnum.ILLEGAL_DRUGS_BUY,
            QuestionIdModelEnum.ILLEGAL_DRUGS_CULTIVATE,
            QuestionIdModelEnum.ILLEGAL_DRUGS_PLANT,
            QuestionIdModelEnum.ILLEGAL_DRUGS_COCAINE,
            QuestionIdModelEnum.ILLEGAL_DRUGS_BLACK_OUT,
            QuestionIdModelEnum.ILLEGAL_DRUGS_SYNTHETIC_EXTEND,
            QuestionIdModelEnum.ILLEGAL_DRUGS_CANCELLING,
            QuestionIdModelEnum.ILLEGAL_DRUGS_COOKING,
            QuestionIdModelEnum.ILLEGAL_DRUGS_FORGETTING
        )

        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question",
                "are",
                "you",
                "fine",
                "finally",
                "so",
                "figure",
                "it",
                "out",
                "still",
                "missing",
                "some",
                "extra"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9],
            stringResourceValue[10],
            stringResourceValue[11],
            stringResourceValue[12],
            stringResourceValue[13],
            stringResourceValue[14],
            stringResourceValue[15],
            stringResourceValue[16]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_illicit) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_one_plus) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_two_plus) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_five_plus) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_synthetic) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_share) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_sell) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_buy) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_cultivate) } returns stringResourceValue[9]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_plant) } returns stringResourceValue[10]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_cocaine) } returns stringResourceValue[11]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_black_out) } returns stringResourceValue[12]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_synthetic_extend) } returns stringResourceValue[13]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_cancelling) } returns stringResourceValue[14]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_cooking) } returns stringResourceValue[15]
        every { stringResourceWrapper.getString(R.string.illegal_drugs_forgetting) } returns stringResourceValue[16]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapIllegalDrugsEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapUniFeelingsEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.UNI_FEELINGS_WEEKEND_PARTY_ONCE,
            QuestionIdModelEnum.UNI_FEELINGS_WEEKEND_PARTY_TWO_PLUS,
            QuestionIdModelEnum.UNI_FEELINGS_WEEKEND_PARTY_FIVE_PLUS,
            QuestionIdModelEnum.UNI_FEELINGS_SEX_UNI,
            QuestionIdModelEnum.UNI_FEELINGS_SEX_CAFETERIA,
            QuestionIdModelEnum.UNI_FEELINGS_SEX_LIBRARY,
            QuestionIdModelEnum.UNI_FEELINGS_SEX_LAB,
            QuestionIdModelEnum.UNI_FEELINGS_SEX_STUDENT_CENTER,
            QuestionIdModelEnum.UNI_FEELINGS_SEX_MAIN_ROOM,
            QuestionIdModelEnum.UNI_FEELINGS_DANCE_TABLE,
            QuestionIdModelEnum.UNI_FEELINGS_DANCE_TABLE_UNDERWEAR
        )
        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question",
                "are",
                "you",
                "fine",
                "finally",
                "so"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9],
            stringResourceValue[10],
            stringResourceValue[11]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.uni_feelings_weekend_party_once) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.uni_feelings_weekend_party_two_plus) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.uni_feelings_weekend_party_five_plus) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.uni_feelings_sex_uni) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.uni_feelings_sex_cafeteria) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.uni_feelings_sex_library) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.uni_feelings_sex_lab) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.uni_feelings_sex_student_center) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.uni_feelings_sex_main_room) } returns stringResourceValue[9]
        every { stringResourceWrapper.getString(R.string.uni_feelings_dance_table) } returns stringResourceValue[10]
        every { stringResourceWrapper.getString(R.string.uni_feelings_dance_table_underwear) } returns stringResourceValue[11]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapUniFeelingsEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapSexEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(
            QuestionIdModelEnum.INVALID,
            QuestionIdModelEnum.SEX_HAD,
            QuestionIdModelEnum.SEX_BORED,
            QuestionIdModelEnum.SEX_KNOWN_SHORT,
            QuestionIdModelEnum.SEX_SLEPT_DURING,
            QuestionIdModelEnum.SEX_SLEPT_EXTRA,
            QuestionIdModelEnum.SEX_SLEPT_EXTRA_SAME_BED,
            QuestionIdModelEnum.SEX_SAME_FAMILY,
            QuestionIdModelEnum.SEX_MILF,
            QuestionIdModelEnum.SEX_PREGNANCY,
            QuestionIdModelEnum.SEX_THREESOME,
            QuestionIdModelEnum.SEX_THREESOME_TWO_WOMAN,
            QuestionIdModelEnum.SEX_THREESOME_TWO_MAN,
            QuestionIdModelEnum.SEX_ORGY,
            QuestionIdModelEnum.SEX_SWING,
            QuestionIdModelEnum.SEX_SAME_NIGHT_TRIPLE,
            QuestionIdModelEnum.SEX_LIFE_COUNT_THREE_PLUS,
            QuestionIdModelEnum.SEX_LIFE_COUNT_TEN_PLUS,
            QuestionIdModelEnum.SEX_BELOW_AGE,
            QuestionIdModelEnum.SEX_ORAL,
            QuestionIdModelEnum.SEX_ANAL,
            QuestionIdModelEnum.SEX_VIRGIN_CHECKED,
            QuestionIdModelEnum.SEX_CONDOMLESS,
            QuestionIdModelEnum.SEX_TOYS,
            QuestionIdModelEnum.SEX_UPSIDE_DOWN,
            QuestionIdModelEnum.SEX_PUBLIC,
            QuestionIdModelEnum.SEX_SHOPPING,
            QuestionIdModelEnum.SEX_MOVIE_THEATRE,
            QuestionIdModelEnum.SEX_FOR_PUBLIC,
            QuestionIdModelEnum.SEX_FILMED,
            QuestionIdModelEnum.SEX_WITHOUT_CONSENT,
            QuestionIdModelEnum.SEX_ANIMAL,
            QuestionIdModelEnum.SEX_PLAT,
            QuestionIdModelEnum.SEX_ROOF,
            QuestionIdModelEnum.SEX_AQUEOUS,
            QuestionIdModelEnum.SEX_NON_NEWTONIAN,
            QuestionIdModelEnum.SEX_EAT_FOOD,
            QuestionIdModelEnum.SEX_SIX_NINE,
            QuestionIdModelEnum.SEX_MULTIPLE_POSITIONS,
            QuestionIdModelEnum.SEX_HAMMOCK,
            QuestionIdModelEnum.SEX_COLONOSCOPY,
            QuestionIdModelEnum.SEX_MENSTRUATION,
            QuestionIdModelEnum.SEX_CLOWN,
            QuestionIdModelEnum.SEX_SURPRISE_SLIP,
            QuestionIdModelEnum.SEX_EXCRETA,
            QuestionIdModelEnum.SEX_BUTT_WASHER,
            QuestionIdModelEnum.SEX_COSTUME
        )

        val stringResourceValue =
            listOf(
                "that",
                "should",
                "be",
                "a",
                "value",
                "here",
                "is",
                "question",
                "are",
                "you",
                "fine",
                "finally",
                "so",
                "figure",
                "it",
                "out",
                "still",
                "missing",
                "some",
                "extra",
                "fake",
                "strings",
                "how",
                "many",
                "elements",
                "I",
                "must",
                "invent",
                "darn",
                "that",
                "was",
                "the",
                "longest",
                "coding",
                "session",
                "I recently",
                "had",
                "curious",
                "how",
                "good",
                "that",
                "will",
                "be",
                "just",
                "three",
                "short",
                "done"
            )

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1],
            stringResourceValue[2],
            stringResourceValue[3],
            stringResourceValue[4],
            stringResourceValue[5],
            stringResourceValue[6],
            stringResourceValue[7],
            stringResourceValue[8],
            stringResourceValue[9],
            stringResourceValue[10],
            stringResourceValue[11],
            stringResourceValue[12],
            stringResourceValue[13],
            stringResourceValue[14],
            stringResourceValue[15],
            stringResourceValue[16],
            stringResourceValue[17],
            stringResourceValue[18],
            stringResourceValue[19],
            stringResourceValue[20],
            stringResourceValue[21],
            stringResourceValue[22],
            stringResourceValue[23],
            stringResourceValue[24],
            stringResourceValue[25],
            stringResourceValue[26],
            stringResourceValue[27],
            stringResourceValue[28],
            stringResourceValue[29],
            stringResourceValue[30],
            stringResourceValue[31],
            stringResourceValue[32],
            stringResourceValue[33],
            stringResourceValue[34],
            stringResourceValue[35],
            stringResourceValue[36],
            stringResourceValue[37],
            stringResourceValue[38],
            stringResourceValue[39],
            stringResourceValue[40],
            stringResourceValue[41],
            stringResourceValue[42],
            stringResourceValue[43],
            stringResourceValue[44],
            stringResourceValue[45],
            stringResourceValue[46]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.sex_had) } returns stringResourceValue[1]
        every { stringResourceWrapper.getString(R.string.sex_bored) } returns stringResourceValue[2]
        every { stringResourceWrapper.getString(R.string.sex_known_short) } returns stringResourceValue[3]
        every { stringResourceWrapper.getString(R.string.sex_slept_during) } returns stringResourceValue[4]
        every { stringResourceWrapper.getString(R.string.sex_slept_extra) } returns stringResourceValue[5]
        every { stringResourceWrapper.getString(R.string.sex_slept_extra_same_bed) } returns stringResourceValue[6]
        every { stringResourceWrapper.getString(R.string.sex_same_family) } returns stringResourceValue[7]
        every { stringResourceWrapper.getString(R.string.sex_milf) } returns stringResourceValue[8]
        every { stringResourceWrapper.getString(R.string.sex_pregnancy) } returns stringResourceValue[9]
        every { stringResourceWrapper.getString(R.string.sex_threesome) } returns stringResourceValue[10]
        every { stringResourceWrapper.getString(R.string.sex_threesome_two_woman) } returns stringResourceValue[11]
        every { stringResourceWrapper.getString(R.string.sex_threesome_two_man) } returns stringResourceValue[12]
        every { stringResourceWrapper.getString(R.string.sex_orgy) } returns stringResourceValue[13]
        every { stringResourceWrapper.getString(R.string.sex_swing) } returns stringResourceValue[14]
        every { stringResourceWrapper.getString(R.string.sex_same_night_triple) } returns stringResourceValue[15]
        every { stringResourceWrapper.getString(R.string.sex_life_count_three_plus) } returns stringResourceValue[16]
        every { stringResourceWrapper.getString(R.string.sex_life_count_ten_plus) } returns stringResourceValue[17]
        every { stringResourceWrapper.getString(R.string.sex_below_age) } returns stringResourceValue[18]
        every { stringResourceWrapper.getString(R.string.sex_oral) } returns stringResourceValue[19]
        every { stringResourceWrapper.getString(R.string.sex_anal) } returns stringResourceValue[20]
        every { stringResourceWrapper.getString(R.string.sex_virgin_checked) } returns stringResourceValue[21]
        every { stringResourceWrapper.getString(R.string.sex_condomless) } returns stringResourceValue[22]
        every { stringResourceWrapper.getString(R.string.sex_toys) } returns stringResourceValue[23]
        every { stringResourceWrapper.getString(R.string.sex_upside_down) } returns stringResourceValue[24]
        every { stringResourceWrapper.getString(R.string.sex_public) } returns stringResourceValue[25]
        every { stringResourceWrapper.getString(R.string.sex_shopping) } returns stringResourceValue[26]
        every { stringResourceWrapper.getString(R.string.sex_movie_theatre) } returns stringResourceValue[27]
        every { stringResourceWrapper.getString(R.string.sex_for_public) } returns stringResourceValue[28]
        every { stringResourceWrapper.getString(R.string.sex_filmed) } returns stringResourceValue[29]
        every { stringResourceWrapper.getString(R.string.sex_without_consent) } returns stringResourceValue[30]
        every { stringResourceWrapper.getString(R.string.sex_animal) } returns stringResourceValue[31]
        every { stringResourceWrapper.getString(R.string.sex_plat) } returns stringResourceValue[32]
        every { stringResourceWrapper.getString(R.string.sex_roof) } returns stringResourceValue[33]
        every { stringResourceWrapper.getString(R.string.sex_aqueous) } returns stringResourceValue[34]
        every { stringResourceWrapper.getString(R.string.sex_non_newtonian) } returns stringResourceValue[35]
        every { stringResourceWrapper.getString(R.string.sex_eat_food) } returns stringResourceValue[36]
        every { stringResourceWrapper.getString(R.string.sex_six_nine) } returns stringResourceValue[37]
        every { stringResourceWrapper.getString(R.string.sex_multiple_positions) } returns stringResourceValue[38]
        every { stringResourceWrapper.getString(R.string.sex_hammock) } returns stringResourceValue[39]
        every { stringResourceWrapper.getString(R.string.sex_colonoscopy) } returns stringResourceValue[40]
        every { stringResourceWrapper.getString(R.string.sex_menstruation) } returns stringResourceValue[41]
        every { stringResourceWrapper.getString(R.string.sex_clown) } returns stringResourceValue[42]
        every { stringResourceWrapper.getString(R.string.sex_surprise_slip) } returns stringResourceValue[43]
        every { stringResourceWrapper.getString(R.string.sex_excreta) } returns stringResourceValue[44]
        every { stringResourceWrapper.getString(R.string.sex_butt_washer) } returns stringResourceValue[45]
        every { stringResourceWrapper.getString(R.string.sex_costume) } returns stringResourceValue[46]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapSexEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapPurityEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum =
            listOf(QuestionIdModelEnum.INVALID, QuestionIdModelEnum.PURITY_SEEKER_TODO)
        val stringResourceValue =
            listOf("that should", "be a value")

        val expected = listOf(
            stringResourceValue[0],
            stringResourceValue[1]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]
        every { stringResourceWrapper.getString(R.string.purity_seeker_todo) } returns stringResourceValue[1]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapPurityEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `GIVEN idModelEnum, WHEN mapInvalidEnumToString, THEN return QuestionTextModel_value`() {
        // GIVEN
        val idModelEnum = listOf(QuestionIdModelEnum.INVALID)
        val stringResourceValue =
            listOf("that should be a value")

        val expected = listOf(
            stringResourceValue[0]
        )

        every { stringResourceWrapper.getString(R.string.questions_id_model_error) } returns stringResourceValue[0]

        // WHEN
        val result = idModelEnum.map { textStringMapper.mapInvalidEnumToString(it) }

        // THEN
        Assert.assertEquals(expected, result)
    }
}
