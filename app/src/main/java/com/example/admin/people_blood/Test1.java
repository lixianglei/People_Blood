package com.example.admin.people_blood;

import java.util.List;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/10 0:02
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Test1 {

    /**
     * data : [{"document_id":"284581","title":"双腿痛会引发什么病","club_id":"16807200","reply":"仅此描述无法判断，若要明确诊断，建议来医院就诊。"},{"document_id":"285096","title":"男63岁这几天右手没劲连筷子都拿不稳什么病症","club_id":"16822433","reply":"可能的原因有两：1、颈椎病，神经受压所致。2、轻度脑中风。建议去医院检查，不要耽误病情。"},{"document_id":"285257","title":"头晕，严重时大小便失禁，不敢睁眼，多数药过敏","club_id":"16826059","reply":"目前的主诉无法判断，如必要可来门诊。"},{"document_id":"286635","title":"眼发抽出冷汗四肢无力脚如踩棉花今年五十以绝经甘油三脂高","club_id":"16861956","reply":"这些症状更像颈椎病的症状，建议来医院查一下。"},{"document_id":"286637","title":"病？弯腰和挺腰非常疼痛不能干活，腿不疼痛，请问医生这是什么","club_id":"16861996","reply":"你的年龄不大，在生活和职业方面是否有不健康的姿势或活动？"},{"document_id":"287716","title":"患有帕金森综合症，时好时坏。可以减轻吗？","club_id":"16863954","reply":"需要联合用药，单药作用有限，建议来医院门诊看一下。"},{"document_id":"287724","title":"你好！我母亲是一位帕金森患者，病史有十多年了，现在全","club_id":"16879246","reply":"接受规范的药物治疗过吗？如果没有，建议来医院门诊看一下。"},{"document_id":"288299","title":"请问左侧基底节区腔隙性梗塞有什么可以吃的药吗？","club_id":"16888902","reply":"可以用些阿斯匹林、血塞通等药物。"},{"document_id":"288317","title":"请问左侧基底节区腔隙性梗塞服用灯盏生脉胶囊管用吗？","club_id":"16888902","reply":"意义不大。"},{"document_id":"289603","title":"你好，我父亲高压200以上血糖血脂都正常有点轻微脑梗怎么样治","club_id":"16919895","reply":"低盐饮食，调整降压药，控制血压是关键。"},{"document_id":"289605","title":"您好，我爸爸的腿经常疼痛应该吃什么药","club_id":"16919912","reply":"腿痛需要检查，明确诊断才能对症用药。"},{"document_id":"289904","title":"脑萎缩，脑梗塞可以治愈吗","club_id":"16924332","reply":"建议来门诊做记忆检查，确定康复治疗方案。"},{"document_id":"289931","title":"患颈椎半年之多","club_id":"16924754","reply":"需要配合药物治疗。"},{"document_id":"289934","title":"脑中风术后是否积水怎判断？","club_id":"16916517","reply":"未见到片子，故无法断定，根据描述软化灶的可能性大些。"},{"document_id":"289946","title":"我母亲患老年痴呆近十年，可以用奥拉西坦吗，是否有效果","club_id":"16924949","reply":"痴呆10年，症状在进展，此时再用奥拉西坦治疗已意义不大。"},{"document_id":"289947","title":"患颈椎病半年之多，疼痛剧烈。","club_id":"16924754","reply":"片子上看有C4/5椎间盘突出，神经根受压明显，需要药物和理疗等综合治疗。"},{"document_id":"289958","title":"髌骨骨折，手术后20多天小腿还是抬不起。","club_id":"16866654","reply":"20天可以在床上做等长收缩训练，6周后进行蜡疗和关节活动度训练。"},{"document_id":"290139","title":"康复治疗方法","club_id":"16879578","reply":"MR结果如何？有无副韧带断裂？如果没有骨折又没有韧带断裂，2个月还不能弯曲，则需要来医院门诊检查一下，才能提供康复治疗方案。"},{"document_id":"290185","title":"闪腰腿疼怎么回事","club_id":"16928653","reply":"需要去医院摄片检查以明确诊断。"},{"document_id":"290293","title":"双侧基底节及放射区示多发斑点状低密度灶，境界模糊，双侧脑室","club_id":"16930190","reply":"多发性腔梗，提示脑缺血改变，需要去医院治疗。"}]
     * code : 10000
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * document_id : 284581
         * title : 双腿痛会引发什么病
         * club_id : 16807200
         * reply : 仅此描述无法判断，若要明确诊断，建议来医院就诊。
         */

        private String document_id;
        private String title;
        private String club_id;
        private String reply;

        public String getDocument_id() {
            return document_id;
        }

        public void setDocument_id(String document_id) {
            this.document_id = document_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getClub_id() {
            return club_id;
        }

        public void setClub_id(String club_id) {
            this.club_id = club_id;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }
    }
}
