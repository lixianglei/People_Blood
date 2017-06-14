package com.example.admin.people_blood.bean;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/13 15:05
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class YuYueBean {

    /**
     * code : 10000
     * data : {"id":"319","name":"李为民","title":"主任医师","teach":"教授","goodat":"高血压病、冠心病、心力衰竭、心律失常的诊断和药物治疗","photo":"http://static.i2.xywy.com/zhuanjia/20141211/c9334b9a40aa134ae02ec0d6dc11ecc134614_a.jpg","info":"李为民，男，主任医师，教授，副院长，博士生导师，院党委书记，内科教研室主任，中华医学会心血管内科学会委员，中华医学会内科学会委员，中国老年保健协会心血管内科专业委员会副主任委员，中国生物工程学会起博与生理学会委员，中华医学会介入培训中心特邀专家，黑龙江省医学会心血管内科专业委员会主任委员，省级重点学科带头人，卫生部有突出贡献中青年专家，黑龙江省优秀中青年专家，《中华心血管病杂志》编委，《中国介入性心脏病学杂志》编委，《中国实用内科杂志》编委，《中国急救医学杂志》副主编，《中国药物与临床杂志》编委。黑龙江省高干保健专家组成员。\r\n\r\n从事心血管内科专业近30年，两次赴美国研修，在高血压病、冠心病、心力衰竭、心律失常的诊断和药物治疗方面有很高造诣，对心血管疑难病症的疹疗有丰富的经验，如经（皮股动脉、桡动脉、尺动脉）途径冠状动脉成形术、冠脉支架术、冠状动脉内超声检查、经皮腔内心机激光打孔术等，手术例数省内领先。","pinyin":"liweimin","expertId":"8143","answernum":"0","is_ask":"1","is_plus":"1","hospital":"哈医大一院","depart":"心血管内科","plusNum":"218","schedule":{"rdtime":[{"title":"2017-06-21 星期三 上午  专家门诊","id":"2464","date":"1497974400","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"门诊2楼心血管内科诊室","msg":"申请预约","already_num":"2","amount":"5","surplus":"3"},{"title":"2017-06-28 星期三 上午  专家门诊","id":"2464","date":"1498579200","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"门诊2楼心血管内科诊室","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"}],"num":{"total":"2","res_num":"2"}},"plus_require":"高血压病、冠心病、心力衰竭、心律失常、心血管介入治疗等。","expert_pinyin":"liweiminzjw","address":"哈尔滨市南岗区东大直街199号","Article":[],"DoctorRely":[]}
     * msg :
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * id : 319
         * name : 李为民
         * title : 主任医师
         * teach : 教授
         * goodat : 高血压病、冠心病、心力衰竭、心律失常的诊断和药物治疗
         * photo : http://static.i2.xywy.com/zhuanjia/20141211/c9334b9a40aa134ae02ec0d6dc11ecc134614_a.jpg
         * info : 李为民，男，主任医师，教授，副院长，博士生导师，院党委书记，内科教研室主任，中华医学会心血管内科学会委员，中华医学会内科学会委员，中国老年保健协会心血管内科专业委员会副主任委员，中国生物工程学会起博与生理学会委员，中华医学会介入培训中心特邀专家，黑龙江省医学会心血管内科专业委员会主任委员，省级重点学科带头人，卫生部有突出贡献中青年专家，黑龙江省优秀中青年专家，《中华心血管病杂志》编委，《中国介入性心脏病学杂志》编委，《中国实用内科杂志》编委，《中国急救医学杂志》副主编，《中国药物与临床杂志》编委。黑龙江省高干保健专家组成员。

         从事心血管内科专业近30年，两次赴美国研修，在高血压病、冠心病、心力衰竭、心律失常的诊断和药物治疗方面有很高造诣，对心血管疑难病症的疹疗有丰富的经验，如经（皮股动脉、桡动脉、尺动脉）途径冠状动脉成形术、冠脉支架术、冠状动脉内超声检查、经皮腔内心机激光打孔术等，手术例数省内领先。
         * pinyin : liweimin
         * expertId : 8143
         * answernum : 0
         * is_ask : 1
         * is_plus : 1
         * hospital : 哈医大一院
         * depart : 心血管内科
         * plusNum : 218
         * schedule : {"rdtime":[{"title":"2017-06-21 星期三 上午  专家门诊","id":"2464","date":"1497974400","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"门诊2楼心血管内科诊室","msg":"申请预约","already_num":"2","amount":"5","surplus":"3"},{"title":"2017-06-28 星期三 上午  专家门诊","id":"2464","date":"1498579200","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"门诊2楼心血管内科诊室","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"}],"num":{"total":"2","res_num":"2"}}
         * plus_require : 高血压病、冠心病、心力衰竭、心律失常、心血管介入治疗等。
         * expert_pinyin : liweiminzjw
         * address : 哈尔滨市南岗区东大直街199号
         * Article : []
         * DoctorRely : []
         */

        private String id;
        private String name;
        private String title;
        private String teach;
        private String goodat;
        private String photo;
        private String info;
        private String pinyin;
        private String expertId;
        private String answernum;
        private String is_ask;
        private String is_plus;
        private String hospital;
        private String depart;
        private String plusNum;
        private ScheduleBean schedule;
        private String plus_require;
        private String expert_pinyin;
        private String address;
        private List<?> Article;
        private List<?> DoctorRely;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTeach() {
            return teach;
        }

        public void setTeach(String teach) {
            this.teach = teach;
        }

        public String getGoodat() {
            return goodat;
        }

        public void setGoodat(String goodat) {
            this.goodat = goodat;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getExpertId() {
            return expertId;
        }

        public void setExpertId(String expertId) {
            this.expertId = expertId;
        }

        public String getAnswernum() {
            return answernum;
        }

        public void setAnswernum(String answernum) {
            this.answernum = answernum;
        }

        public String getIs_ask() {
            return is_ask;
        }

        public void setIs_ask(String is_ask) {
            this.is_ask = is_ask;
        }

        public String getIs_plus() {
            return is_plus;
        }

        public void setIs_plus(String is_plus) {
            this.is_plus = is_plus;
        }

        public String getHospital() {
            return hospital;
        }

        public void setHospital(String hospital) {
            this.hospital = hospital;
        }

        public String getDepart() {
            return depart;
        }

        public void setDepart(String depart) {
            this.depart = depart;
        }

        public String getPlusNum() {
            return plusNum;
        }

        public void setPlusNum(String plusNum) {
            this.plusNum = plusNum;
        }

        public ScheduleBean getSchedule() {
            return schedule;
        }

        public void setSchedule(ScheduleBean schedule) {
            this.schedule = schedule;
        }

        public String getPlus_require() {
            return plus_require;
        }

        public void setPlus_require(String plus_require) {
            this.plus_require = plus_require;
        }

        public String getExpert_pinyin() {
            return expert_pinyin;
        }

        public void setExpert_pinyin(String expert_pinyin) {
            this.expert_pinyin = expert_pinyin;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public List<?> getArticle() {
            return Article;
        }

        public void setArticle(List<?> Article) {
            this.Article = Article;
        }

        public List<?> getDoctorRely() {
            return DoctorRely;
        }

        public void setDoctorRely(List<?> DoctorRely) {
            this.DoctorRely = DoctorRely;
        }

        public static class ScheduleBean {
            /**
             * rdtime : [{"title":"2017-06-21 星期三 上午  专家门诊","id":"2464","date":"1497974400","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"门诊2楼心血管内科诊室","msg":"申请预约","already_num":"2","amount":"5","surplus":"3"},{"title":"2017-06-28 星期三 上午  专家门诊","id":"2464","date":"1498579200","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"门诊2楼心血管内科诊室","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"}]
             * num : {"total":"2","res_num":"2"}
             */

            private NumBean num;
            private List<RdtimeBean> rdtime;

            public NumBean getNum() {
                return num;
            }

            public void setNum(NumBean num) {
                this.num = num;
            }

            public List<RdtimeBean> getRdtime() {
                return rdtime;
            }

            public void setRdtime(List<RdtimeBean> rdtime) {
                this.rdtime = rdtime;
            }

            public static class NumBean {
                /**
                 * total : 2
                 * res_num : 2
                 */

                private String total;
                private String res_num;

                public String getTotal() {
                    return total;
                }

                public void setTotal(String total) {
                    this.total = total;
                }

                public String getRes_num() {
                    return res_num;
                }

                public void setRes_num(String res_num) {
                    this.res_num = res_num;
                }
            }

            public static class RdtimeBean {
                /**
                 * title : 2017-06-21 星期三 上午  专家门诊
                 * id : 2464
                 * date : 1497974400
                 * week : 3
                 * halfday : 1
                 * type : 2
                 * state : 1
                 * money :
                 * address : 门诊2楼心血管内科诊室
                 * msg : 申请预约
                 * already_num : 2
                 * amount : 5
                 * surplus : 3
                 */

                private String title;
                private String id;
                private String date;
                private String week;
                private String halfday;
                private String type;
                private String state;
                private String money;
                private String address;
                private String msg;
                private String already_num;
                private String amount;
                private String surplus;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getHalfday() {
                    return halfday;
                }

                public void setHalfday(String halfday) {
                    this.halfday = halfday;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public String getMoney() {
                    return money;
                }

                public void setMoney(String money) {
                    this.money = money;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getMsg() {
                    return msg;
                }

                public void setMsg(String msg) {
                    this.msg = msg;
                }

                public String getAlready_num() {
                    return already_num;
                }

                public void setAlready_num(String already_num) {
                    this.already_num = already_num;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public String getSurplus() {
                    return surplus;
                }

                public void setSurplus(String surplus) {
                    this.surplus = surplus;
                }
            }
        }
    }
}
