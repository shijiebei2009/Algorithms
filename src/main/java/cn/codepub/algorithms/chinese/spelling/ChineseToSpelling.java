package cn.codepub.algorithms.chinese.spelling;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/12/12 23:47
 * </p>
 * <p>
 * ClassName:ChineseToSpelling
 * </p>
 * <p>
 * Description:使用JPinyin组件将汉字转成拼音
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class ChineseToSpelling {
    /**
     *
     */
    public static String convertChineseToSpelling(String chinese, SpellingFormat spellingFormat) {
        String res = null;
        switch (spellingFormat) {
            case WITH_TONE_MARK:
                res = PinyinHelper.convertToPinyinString(chinese, ",", PinyinFormat.WITH_TONE_MARK); // nǐ,hǎo,shì,jiè
                break;
            case WITH_TONE_NUMBER:
                res = PinyinHelper.convertToPinyinString(chinese, ",", PinyinFormat.WITH_TONE_NUMBER); // ni3,hao3,shi4,jie4
                break;
            case WITHOUT_TONE:
                res = PinyinHelper.convertToPinyinString(chinese, ",", PinyinFormat.WITHOUT_TONE); // ni,hao,shi,jie
                break;
            case SHORT_PINYIN:
                res = PinyinHelper.getShortPinyin(chinese); // nhsj
                break;
            default:
                res = "ERROR";
        }
        return res;
    }
}

enum SpellingFormat {
    WITH_TONE_MARK, WITH_TONE_NUMBER, WITHOUT_TONE, SHORT_PINYIN;
}