package com.example.admin.people_blood.bean;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/15 21:26
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TimeBean {

    /**
     * result : 1
     * msg :
     * data : {"id":"197332","name":"刘清军","title":"副主任医师","teach":"副教授","goodat":"三叉神经痛、舌咽神经痛、面肌痉挛、顽固性头痛、糖尿病性神经痛、颈腰椎间盘突出症、中枢痛、脊髓损伤后神经痛、带状疱疹后遗痛、颈肩痛、内脏痛、腰腿痛、神经源性高血压、末梢神经炎、周围神经卡压症。","photo":"http://static.i2.xywy.com/zhuanjia/20140611/c5f34b8246c3d9bf1e13aa7bbe33df2798246_a.jpg","info":"刘清军，男，副主任医师，医学博士，硕士研究生导师，天津市环湖医院疼痛科主任，中华医学会疼痛学分会中枢痛组员，天津医学会疼痛学分会委员。从事神经外科临床、教学、科研20余年，具有丰富的临床经验。2007年曾在北京宣武医院功能神经外科进行神经病理性疼痛的外科治疗、2012年作为访问学者赴韩国及加拿大学习颈腰椎键盘突出症的微创治疗。目前主要从事顽固性疼痛的临床实践与研究，擅长三叉神经痛、舌咽神经痛、面肌痉挛、糖尿病性神经痛、顽固性头痛、中枢痛、脊髓损伤后神经痛、带状疱疹后遗痛、颈肩痛、内脏痛、腰腿痛、神经源性高血压、颈腰椎间盘突出症、末梢神经炎、周围神经卡压症。","pinyin":"tjliuqingjun","expertId":"10636","answernum":"414","is_ask":"1","is_plus":"1","hospital":"天津市环湖医院","depart":"神经外科","plusNum":"38","schedule":{"rdtime":[{"title":"2017-06-19 星期一 上午  专家门诊","id":"32422","date":"1497801600","week":"1","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-20 星期二 上午  专家门诊","id":"32423","date":"1497888000","week":"2","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-21 星期三 上午  专家门诊","id":"32424","date":"1497974400","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-22 星期四 上午  专家门诊","id":"32425","date":"1498060800","week":"4","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-26 星期一 上午  专家门诊","id":"32422","date":"1498406400","week":"1","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-27 星期二 上午  专家门诊","id":"32423","date":"1498492800","week":"2","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-28 星期三 上午  专家门诊","id":"32424","date":"1498579200","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-29 星期四 上午  专家门诊","id":"32425","date":"1498665600","week":"4","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-07-03 星期一 上午  专家门诊","id":"32422","date":"1499011200","week":"1","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-07-04 星期二 上午  专家门诊","id":"32423","date":"1499097600","week":"2","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"}],"num":{"total":"10","res_num":"10"}},"plus_require":"三叉神经痛、偏头痛、舌咽神经痛、颈椎间盘突出、腰椎间盘突出、糖尿病性神经痛，中枢痛、带状疱疹后遗痛，周围神经卡压症，各种顽固性疼痛等。","expert_pinyin":"liuqingjun","address":"天津市津南区吉兆路6号"}
     */

    private int result;
    private String msg;
    private DataBean data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 197332
         * name : 刘清军
         * title : 副主任医师
         * teach : 副教授
         * goodat : 三叉神经痛、舌咽神经痛、面肌痉挛、顽固性头痛、糖尿病性神经痛、颈腰椎间盘突出症、中枢痛、脊髓损伤后神经痛、带状疱疹后遗痛、颈肩痛、内脏痛、腰腿痛、神经源性高血压、末梢神经炎、周围神经卡压症。
         * photo : http://static.i2.xywy.com/zhuanjia/20140611/c5f34b8246c3d9bf1e13aa7bbe33df2798246_a.jpg
         * info : 刘清军，男，副主任医师，医学博士，硕士研究生导师，天津市环湖医院疼痛科主任，中华医学会疼痛学分会中枢痛组员，天津医学会疼痛学分会委员。从事神经外科临床、教学、科研20余年，具有丰富的临床经验。2007年曾在北京宣武医院功能神经外科进行神经病理性疼痛的外科治疗、2012年作为访问学者赴韩国及加拿大学习颈腰椎键盘突出症的微创治疗。目前主要从事顽固性疼痛的临床实践与研究，擅长三叉神经痛、舌咽神经痛、面肌痉挛、糖尿病性神经痛、顽固性头痛、中枢痛、脊髓损伤后神经痛、带状疱疹后遗痛、颈肩痛、内脏痛、腰腿痛、神经源性高血压、颈腰椎间盘突出症、末梢神经炎、周围神经卡压症。
         * pinyin : tjliuqingjun
         * expertId : 10636
         * answernum : 414
         * is_ask : 1
         * is_plus : 1
         * hospital : 天津市环湖医院
         * depart : 神经外科
         * plusNum : 38
         * schedule : {"rdtime":[{"title":"2017-06-19 星期一 上午  专家门诊","id":"32422","date":"1497801600","week":"1","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-20 星期二 上午  专家门诊","id":"32423","date":"1497888000","week":"2","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-21 星期三 上午  专家门诊","id":"32424","date":"1497974400","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-22 星期四 上午  专家门诊","id":"32425","date":"1498060800","week":"4","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-26 星期一 上午  专家门诊","id":"32422","date":"1498406400","week":"1","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-27 星期二 上午  专家门诊","id":"32423","date":"1498492800","week":"2","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-28 星期三 上午  专家门诊","id":"32424","date":"1498579200","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-29 星期四 上午  专家门诊","id":"32425","date":"1498665600","week":"4","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-07-03 星期一 上午  专家门诊","id":"32422","date":"1499011200","week":"1","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-07-04 星期二 上午  专家门诊","id":"32423","date":"1499097600","week":"2","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"}],"num":{"total":"10","res_num":"10"}}
         * plus_require : 三叉神经痛、偏头痛、舌咽神经痛、颈椎间盘突出、腰椎间盘突出、糖尿病性神经痛，中枢痛、带状疱疹后遗痛，周围神经卡压症，各种顽固性疼痛等。
         * expert_pinyin : liuqingjun
         * address : 天津市津南区吉兆路6号
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

        public static class ScheduleBean {
            /**
             * rdtime : [{"title":"2017-06-19 星期一 上午  专家门诊","id":"32422","date":"1497801600","week":"1","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-20 星期二 上午  专家门诊","id":"32423","date":"1497888000","week":"2","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-21 星期三 上午  专家门诊","id":"32424","date":"1497974400","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-22 星期四 上午  专家门诊","id":"32425","date":"1498060800","week":"4","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-26 星期一 上午  专家门诊","id":"32422","date":"1498406400","week":"1","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-27 星期二 上午  专家门诊","id":"32423","date":"1498492800","week":"2","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-28 星期三 上午  专家门诊","id":"32424","date":"1498579200","week":"3","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-06-29 星期四 上午  专家门诊","id":"32425","date":"1498665600","week":"4","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-07-03 星期一 上午  专家门诊","id":"32422","date":"1499011200","week":"1","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"},{"title":"2017-07-04 星期二 上午  专家门诊","id":"32423","date":"1499097600","week":"2","halfday":"1","type":"2","state":"1","money":"","address":"（上午8:30）到环湖医院二楼疼痛科门诊","msg":"申请预约","already_num":"0","amount":"5","surplus":"5"}]
             * num : {"total":"10","res_num":"10"}
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
                 * total : 10
                 * res_num : 10
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
                 * title : 2017-06-19 星期一 上午  专家门诊
                 * id : 32422
                 * date : 1497801600
                 * week : 1
                 * halfday : 1
                 * type : 2
                 * state : 1
                 * money :
                 * address : （上午8:30）到环湖医院二楼疼痛科门诊
                 * msg : 申请预约
                 * already_num : 0
                 * amount : 5
                 * surplus : 5
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
