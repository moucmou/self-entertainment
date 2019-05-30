package com.self.entertainment.jetty.server;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2019/5/29 16:02
 */
public class Tst {


    /**
     * dateTime : 2019-05-29T08:02:07Z
     * eventState : active
     * ipAddress : 10.20.84.151
     * eventDescription : captureLibResult
     * activePostCount : 1
     * captureLibResult : [{"errorCode":1,"errorMsg":"ok","image":"http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=d8540fbba2748936KyBHHassLsWOSVGh4hwJPkMssVt+SrNTsjRr5TbKDDhHUNYFXVjQv2WcxaO1RvIzY/0=&componentId=PIC&serviceType=PICwebapp","traceUuid":"1234564456456","traceIdx":1,"faces":[{"faceId":1,"faceRect":{"x":0.309211,"y":0.254072,"width":0.41886,"height":0.312704},"faceMark":{"leftEye":{"x":0.470873,"y":0.33726},"rightEye":{"x":0.624341,"y":0.370494},"leftMouth":{"x":0.441755,"y":0.471769},"rightMouth":{"x":0.564235,"y":0.49584},"noseTip":{"x":0.535732,"y":0.410261}},"recommendFaceRect":{"x":0,"y":0,"width":1,"height":0.938111},"facePose":{"pitch":7.328125,"roll":-16.256094,"yaw":-6.1875,"confidence":0},"age":{"range":5,"value":25,"ageGroup":"young"},"gender":{"confidence":0.998976,"value":"male"},"glass":{"confidence":0.999484,"value":"yes"},"smile":{"confidence":0.999637,"value":"yes"},"ethnic":{"confidence":0.999996,"value":"no"},"modeldata":"SElLREZSNDIxMTBYAAAAAN3wLkLw8v4e8cAh8uLQIQPrLu/eAzAfMNDQ0u8jBCBQLzEiD/8yIR/wIAEU4hIBACABHQEDEPP+EPIPIMsVHsEAACAiECAPwQKx/RAAAuQO7xAB/w4SHx4s4TDSDr4v0QI9QC7x8NH9OhMc8RIjMS7eD/EvIO7QAfMe8OHkBNQA7gAxEP/Q0gMuEf4REQIBMcf7MQ4C/wAR/b/+BN7A7Pw0EgP+Hj8QEB4DEQ8iAD4UAB8O/h7xQRFRzx/iHx8P8//v7dIV7g8PAA8e5OPgA+/zHR8uXQAxATDy/yNAb+LyMSIDAhE+HtMeHtMQ4R8S4PDg0hIOAPL+7xLr8RAODP0i8OAw8A5NLf/+LTEDEREvEAAC7wDSAf0OHD8OMRD+zxEx0CHfDuLe8D4AEMEA4TQAQxHw7wLg/+/PAdEe7xEAH/4w3/1DDRHg7vEG4f0LsAAiAg7x8RAdMwLeAf7hEeK9HsATMD8uDdAOA/sg0gEvUhDeMm7iJO8PLu8QLh1MEAMvER9N0BAy8QLV9PLc8gAd/vHyAOAF8h0v8mE94A8gEEEA/tMgHvPAMQEt8wz/E1Mu7RDuT/0SL/8dAPEQLQDeAPThIQ4TBP1A3hQc0M7QMSEhHyDB/uDQ/y0v/0AfMvLB/w/hDg3x7xQu8vHs4CMf/d/eAODPDh/8sh7hAu7w","identify":[{"relationId":1,"maxsimilarity":1,"candidate":[{"alarmId":1,"blacklist_id":"19","human_data":[{"face_id":"c625fa4edadb426e92ee5de1f2842933","bkg_picurl":"","face_picurl":"http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=f025202485f03a4bS207FwWhNvgwnLcb0J2jmWrGxFMKnnaJWd1cZY1zw6my3H/JHUfm0aGTkgYgGpUB9sw=&componentId=PIC&serviceType=PICwebapp","face_rect":{"x":0,"y":0,"height":0,"width":0},"similarity":1}],"human_id":"18f79e12-4429-438d-ac13-7f2e561deedd","reserve_field":"{\"version\":\"hcm-1.0\",\"humanName\":\"18f79e12-4429-438d-ac13-7f2e561deedd\",\"humanAge\":0,\"humanMale\":0,\"humanCredtype\":0}","similarity":1}]}],"faceIQA":{"detectQuality":0,"pointsQuality":0.921875,"eyeDistance":72.895668,"colorful":1,"grayScale":140,"grayMean":128.238754,"grayVar":35.99176,"clearity":0.7,"posePitch":7.328125,"poseRoll":-16.256094,"poseYaw":-6.1875,"poseConf":0,"frontal":0,"uncovered":1,"totalQuality":0.654121}}]}]
     * eventType : captureResult
     */

    private String dateTime;
    private String eventState;
    private String ipAddress;
    private String eventDescription;
    private int activePostCount;
    private String eventType;
    private List<CaptureLibResultBean> captureLibResult;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getEventState() {
        return eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getActivePostCount() {
        return activePostCount;
    }

    public void setActivePostCount(int activePostCount) {
        this.activePostCount = activePostCount;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public List<CaptureLibResultBean> getCaptureLibResult() {
        return captureLibResult;
    }

    public void setCaptureLibResult(List<CaptureLibResultBean> captureLibResult) {
        this.captureLibResult = captureLibResult;
    }

    public static class CaptureLibResultBean {
        /**
         * errorCode : 1
         * errorMsg : ok
         * image : http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=d8540fbba2748936KyBHHassLsWOSVGh4hwJPkMssVt+SrNTsjRr5TbKDDhHUNYFXVjQv2WcxaO1RvIzY/0=&componentId=PIC&serviceType=PICwebapp
         * traceUuid : 1234564456456
         * traceIdx : 1
         * faces : [{"faceId":1,"faceRect":{"x":0.309211,"y":0.254072,"width":0.41886,"height":0.312704},"faceMark":{"leftEye":{"x":0.470873,"y":0.33726},"rightEye":{"x":0.624341,"y":0.370494},"leftMouth":{"x":0.441755,"y":0.471769},"rightMouth":{"x":0.564235,"y":0.49584},"noseTip":{"x":0.535732,"y":0.410261}},"recommendFaceRect":{"x":0,"y":0,"width":1,"height":0.938111},"facePose":{"pitch":7.328125,"roll":-16.256094,"yaw":-6.1875,"confidence":0},"age":{"range":5,"value":25,"ageGroup":"young"},"gender":{"confidence":0.998976,"value":"male"},"glass":{"confidence":0.999484,"value":"yes"},"smile":{"confidence":0.999637,"value":"yes"},"ethnic":{"confidence":0.999996,"value":"no"},"modeldata":"SElLREZSNDIxMTBYAAAAAN3wLkLw8v4e8cAh8uLQIQPrLu/eAzAfMNDQ0u8jBCBQLzEiD/8yIR/wIAEU4hIBACABHQEDEPP+EPIPIMsVHsEAACAiECAPwQKx/RAAAuQO7xAB/w4SHx4s4TDSDr4v0QI9QC7x8NH9OhMc8RIjMS7eD/EvIO7QAfMe8OHkBNQA7gAxEP/Q0gMuEf4REQIBMcf7MQ4C/wAR/b/+BN7A7Pw0EgP+Hj8QEB4DEQ8iAD4UAB8O/h7xQRFRzx/iHx8P8//v7dIV7g8PAA8e5OPgA+/zHR8uXQAxATDy/yNAb+LyMSIDAhE+HtMeHtMQ4R8S4PDg0hIOAPL+7xLr8RAODP0i8OAw8A5NLf/+LTEDEREvEAAC7wDSAf0OHD8OMRD+zxEx0CHfDuLe8D4AEMEA4TQAQxHw7wLg/+/PAdEe7xEAH/4w3/1DDRHg7vEG4f0LsAAiAg7x8RAdMwLeAf7hEeK9HsATMD8uDdAOA/sg0gEvUhDeMm7iJO8PLu8QLh1MEAMvER9N0BAy8QLV9PLc8gAd/vHyAOAF8h0v8mE94A8gEEEA/tMgHvPAMQEt8wz/E1Mu7RDuT/0SL/8dAPEQLQDeAPThIQ4TBP1A3hQc0M7QMSEhHyDB/uDQ/y0v/0AfMvLB/w/hDg3x7xQu8vHs4CMf/d/eAODPDh/8sh7hAu7w","identify":[{"relationId":1,"maxsimilarity":1,"candidate":[{"alarmId":1,"blacklist_id":"19","human_data":[{"face_id":"c625fa4edadb426e92ee5de1f2842933","bkg_picurl":"","face_picurl":"http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=f025202485f03a4bS207FwWhNvgwnLcb0J2jmWrGxFMKnnaJWd1cZY1zw6my3H/JHUfm0aGTkgYgGpUB9sw=&componentId=PIC&serviceType=PICwebapp","face_rect":{"x":0,"y":0,"height":0,"width":0},"similarity":1}],"human_id":"18f79e12-4429-438d-ac13-7f2e561deedd","reserve_field":"{\"version\":\"hcm-1.0\",\"humanName\":\"18f79e12-4429-438d-ac13-7f2e561deedd\",\"humanAge\":0,\"humanMale\":0,\"humanCredtype\":0}","similarity":1}]}],"faceIQA":{"detectQuality":0,"pointsQuality":0.921875,"eyeDistance":72.895668,"colorful":1,"grayScale":140,"grayMean":128.238754,"grayVar":35.99176,"clearity":0.7,"posePitch":7.328125,"poseRoll":-16.256094,"poseYaw":-6.1875,"poseConf":0,"frontal":0,"uncovered":1,"totalQuality":0.654121}}]
         */

        private int errorCode;
        private String errorMsg;
        private String image;
        private String traceUuid;
        private int traceIdx;
        private List<FacesBean> faces;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTraceUuid() {
            return traceUuid;
        }

        public void setTraceUuid(String traceUuid) {
            this.traceUuid = traceUuid;
        }

        public int getTraceIdx() {
            return traceIdx;
        }

        public void setTraceIdx(int traceIdx) {
            this.traceIdx = traceIdx;
        }

        public List<FacesBean> getFaces() {
            return faces;
        }

        public void setFaces(List<FacesBean> faces) {
            this.faces = faces;
        }

        public static class FacesBean {
            /**
             * faceId : 1
             * faceRect : {"x":0.309211,"y":0.254072,"width":0.41886,"height":0.312704}
             * faceMark : {"leftEye":{"x":0.470873,"y":0.33726},"rightEye":{"x":0.624341,"y":0.370494},"leftMouth":{"x":0.441755,"y":0.471769},"rightMouth":{"x":0.564235,"y":0.49584},"noseTip":{"x":0.535732,"y":0.410261}}
             * recommendFaceRect : {"x":0,"y":0,"width":1,"height":0.938111}
             * facePose : {"pitch":7.328125,"roll":-16.256094,"yaw":-6.1875,"confidence":0}
             * age : {"range":5,"value":25,"ageGroup":"young"}
             * gender : {"confidence":0.998976,"value":"male"}
             * glass : {"confidence":0.999484,"value":"yes"}
             * smile : {"confidence":0.999637,"value":"yes"}
             * ethnic : {"confidence":0.999996,"value":"no"}
             * modeldata : SElLREZSNDIxMTBYAAAAAN3wLkLw8v4e8cAh8uLQIQPrLu/eAzAfMNDQ0u8jBCBQLzEiD/8yIR/wIAEU4hIBACABHQEDEPP+EPIPIMsVHsEAACAiECAPwQKx/RAAAuQO7xAB/w4SHx4s4TDSDr4v0QI9QC7x8NH9OhMc8RIjMS7eD/EvIO7QAfMe8OHkBNQA7gAxEP/Q0gMuEf4REQIBMcf7MQ4C/wAR/b/+BN7A7Pw0EgP+Hj8QEB4DEQ8iAD4UAB8O/h7xQRFRzx/iHx8P8//v7dIV7g8PAA8e5OPgA+/zHR8uXQAxATDy/yNAb+LyMSIDAhE+HtMeHtMQ4R8S4PDg0hIOAPL+7xLr8RAODP0i8OAw8A5NLf/+LTEDEREvEAAC7wDSAf0OHD8OMRD+zxEx0CHfDuLe8D4AEMEA4TQAQxHw7wLg/+/PAdEe7xEAH/4w3/1DDRHg7vEG4f0LsAAiAg7x8RAdMwLeAf7hEeK9HsATMD8uDdAOA/sg0gEvUhDeMm7iJO8PLu8QLh1MEAMvER9N0BAy8QLV9PLc8gAd/vHyAOAF8h0v8mE94A8gEEEA/tMgHvPAMQEt8wz/E1Mu7RDuT/0SL/8dAPEQLQDeAPThIQ4TBP1A3hQc0M7QMSEhHyDB/uDQ/y0v/0AfMvLB/w/hDg3x7xQu8vHs4CMf/d/eAODPDh/8sh7hAu7w
             * identify : [{"relationId":1,"maxsimilarity":1,"candidate":[{"alarmId":1,"blacklist_id":"19","human_data":[{"face_id":"c625fa4edadb426e92ee5de1f2842933","bkg_picurl":"","face_picurl":"http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=f025202485f03a4bS207FwWhNvgwnLcb0J2jmWrGxFMKnnaJWd1cZY1zw6my3H/JHUfm0aGTkgYgGpUB9sw=&componentId=PIC&serviceType=PICwebapp","face_rect":{"x":0,"y":0,"height":0,"width":0},"similarity":1}],"human_id":"18f79e12-4429-438d-ac13-7f2e561deedd","reserve_field":"{\"version\":\"hcm-1.0\",\"humanName\":\"18f79e12-4429-438d-ac13-7f2e561deedd\",\"humanAge\":0,\"humanMale\":0,\"humanCredtype\":0}","similarity":1}]}]
             * faceIQA : {"detectQuality":0,"pointsQuality":0.921875,"eyeDistance":72.895668,"colorful":1,"grayScale":140,"grayMean":128.238754,"grayVar":35.99176,"clearity":0.7,"posePitch":7.328125,"poseRoll":-16.256094,"poseYaw":-6.1875,"poseConf":0,"frontal":0,"uncovered":1,"totalQuality":0.654121}
             */

            private int faceId;
            private FaceRectBean faceRect;
            private FaceMarkBean faceMark;
            private RecommendFaceRectBean recommendFaceRect;
            private FacePoseBean facePose;
            private AgeBean age;
            private GenderBean gender;
            private GlassBean glass;
            private SmileBean smile;
            private EthnicBean ethnic;
            private String modeldata;
            private FaceIQABean faceIQA;
            private List<IdentifyBean> identify;

            public int getFaceId() {
                return faceId;
            }

            public void setFaceId(int faceId) {
                this.faceId = faceId;
            }

            public FaceRectBean getFaceRect() {
                return faceRect;
            }

            public void setFaceRect(FaceRectBean faceRect) {
                this.faceRect = faceRect;
            }

            public FaceMarkBean getFaceMark() {
                return faceMark;
            }

            public void setFaceMark(FaceMarkBean faceMark) {
                this.faceMark = faceMark;
            }

            public RecommendFaceRectBean getRecommendFaceRect() {
                return recommendFaceRect;
            }

            public void setRecommendFaceRect(RecommendFaceRectBean recommendFaceRect) {
                this.recommendFaceRect = recommendFaceRect;
            }

            public FacePoseBean getFacePose() {
                return facePose;
            }

            public void setFacePose(FacePoseBean facePose) {
                this.facePose = facePose;
            }

            public AgeBean getAge() {
                return age;
            }

            public void setAge(AgeBean age) {
                this.age = age;
            }

            public GenderBean getGender() {
                return gender;
            }

            public void setGender(GenderBean gender) {
                this.gender = gender;
            }

            public GlassBean getGlass() {
                return glass;
            }

            public void setGlass(GlassBean glass) {
                this.glass = glass;
            }

            public SmileBean getSmile() {
                return smile;
            }

            public void setSmile(SmileBean smile) {
                this.smile = smile;
            }

            public EthnicBean getEthnic() {
                return ethnic;
            }

            public void setEthnic(EthnicBean ethnic) {
                this.ethnic = ethnic;
            }

            public String getModeldata() {
                return modeldata;
            }

            public void setModeldata(String modeldata) {
                this.modeldata = modeldata;
            }

            public FaceIQABean getFaceIQA() {
                return faceIQA;
            }

            public void setFaceIQA(FaceIQABean faceIQA) {
                this.faceIQA = faceIQA;
            }

            public List<IdentifyBean> getIdentify() {
                return identify;
            }

            public void setIdentify(List<IdentifyBean> identify) {
                this.identify = identify;
            }

            public static class FaceRectBean {
                /**
                 * x : 0.309211
                 * y : 0.254072
                 * width : 0.41886
                 * height : 0.312704
                 */

                private double x;
                private double y;
                private double width;
                private double height;

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public double getWidth() {
                    return width;
                }

                public void setWidth(double width) {
                    this.width = width;
                }

                public double getHeight() {
                    return height;
                }

                public void setHeight(double height) {
                    this.height = height;
                }
            }

            public static class FaceMarkBean {
                /**
                 * leftEye : {"x":0.470873,"y":0.33726}
                 * rightEye : {"x":0.624341,"y":0.370494}
                 * leftMouth : {"x":0.441755,"y":0.471769}
                 * rightMouth : {"x":0.564235,"y":0.49584}
                 * noseTip : {"x":0.535732,"y":0.410261}
                 */

                private LeftEyeBean leftEye;
                private RightEyeBean rightEye;
                private LeftMouthBean leftMouth;
                private RightMouthBean rightMouth;
                private NoseTipBean noseTip;

                public LeftEyeBean getLeftEye() {
                    return leftEye;
                }

                public void setLeftEye(LeftEyeBean leftEye) {
                    this.leftEye = leftEye;
                }

                public RightEyeBean getRightEye() {
                    return rightEye;
                }

                public void setRightEye(RightEyeBean rightEye) {
                    this.rightEye = rightEye;
                }

                public LeftMouthBean getLeftMouth() {
                    return leftMouth;
                }

                public void setLeftMouth(LeftMouthBean leftMouth) {
                    this.leftMouth = leftMouth;
                }

                public RightMouthBean getRightMouth() {
                    return rightMouth;
                }

                public void setRightMouth(RightMouthBean rightMouth) {
                    this.rightMouth = rightMouth;
                }

                public NoseTipBean getNoseTip() {
                    return noseTip;
                }

                public void setNoseTip(NoseTipBean noseTip) {
                    this.noseTip = noseTip;
                }

                public static class LeftEyeBean {
                    /**
                     * x : 0.470873
                     * y : 0.33726
                     */

                    private double x;
                    private double y;

                    public double getX() {
                        return x;
                    }

                    public void setX(double x) {
                        this.x = x;
                    }

                    public double getY() {
                        return y;
                    }

                    public void setY(double y) {
                        this.y = y;
                    }
                }

                public static class RightEyeBean {
                    /**
                     * x : 0.624341
                     * y : 0.370494
                     */

                    private double x;
                    private double y;

                    public double getX() {
                        return x;
                    }

                    public void setX(double x) {
                        this.x = x;
                    }

                    public double getY() {
                        return y;
                    }

                    public void setY(double y) {
                        this.y = y;
                    }
                }

                public static class LeftMouthBean {
                    /**
                     * x : 0.441755
                     * y : 0.471769
                     */

                    private double x;
                    private double y;

                    public double getX() {
                        return x;
                    }

                    public void setX(double x) {
                        this.x = x;
                    }

                    public double getY() {
                        return y;
                    }

                    public void setY(double y) {
                        this.y = y;
                    }
                }

                public static class RightMouthBean {
                    /**
                     * x : 0.564235
                     * y : 0.49584
                     */

                    private double x;
                    private double y;

                    public double getX() {
                        return x;
                    }

                    public void setX(double x) {
                        this.x = x;
                    }

                    public double getY() {
                        return y;
                    }

                    public void setY(double y) {
                        this.y = y;
                    }
                }

                public static class NoseTipBean {
                    /**
                     * x : 0.535732
                     * y : 0.410261
                     */

                    private double x;
                    private double y;

                    public double getX() {
                        return x;
                    }

                    public void setX(double x) {
                        this.x = x;
                    }

                    public double getY() {
                        return y;
                    }

                    public void setY(double y) {
                        this.y = y;
                    }
                }
            }

            public static class RecommendFaceRectBean {
                /**
                 * x : 0
                 * y : 0
                 * width : 1
                 * height : 0.938111
                 */

                private int x;
                private int y;
                private int width;
                private double height;

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public double getHeight() {
                    return height;
                }

                public void setHeight(double height) {
                    this.height = height;
                }
            }

            public static class FacePoseBean {
                /**
                 * pitch : 7.328125
                 * roll : -16.256094
                 * yaw : -6.1875
                 * confidence : 0
                 */

                private double pitch;
                private double roll;
                private double yaw;
                private int confidence;

                public double getPitch() {
                    return pitch;
                }

                public void setPitch(double pitch) {
                    this.pitch = pitch;
                }

                public double getRoll() {
                    return roll;
                }

                public void setRoll(double roll) {
                    this.roll = roll;
                }

                public double getYaw() {
                    return yaw;
                }

                public void setYaw(double yaw) {
                    this.yaw = yaw;
                }

                public int getConfidence() {
                    return confidence;
                }

                public void setConfidence(int confidence) {
                    this.confidence = confidence;
                }
            }

            public static class AgeBean {
                /**
                 * range : 5
                 * value : 25
                 * ageGroup : young
                 */

                private int range;
                private int value;
                private String ageGroup;

                public int getRange() {
                    return range;
                }

                public void setRange(int range) {
                    this.range = range;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getAgeGroup() {
                    return ageGroup;
                }

                public void setAgeGroup(String ageGroup) {
                    this.ageGroup = ageGroup;
                }
            }

            public static class GenderBean {
                /**
                 * confidence : 0.998976
                 * value : male
                 */

                private double confidence;
                private String value;

                public double getConfidence() {
                    return confidence;
                }

                public void setConfidence(double confidence) {
                    this.confidence = confidence;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class GlassBean {
                /**
                 * confidence : 0.999484
                 * value : yes
                 */

                private double confidence;
                private String value;

                public double getConfidence() {
                    return confidence;
                }

                public void setConfidence(double confidence) {
                    this.confidence = confidence;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class SmileBean {
                /**
                 * confidence : 0.999637
                 * value : yes
                 */

                private double confidence;
                private String value;

                public double getConfidence() {
                    return confidence;
                }

                public void setConfidence(double confidence) {
                    this.confidence = confidence;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class EthnicBean {
                /**
                 * confidence : 0.999996
                 * value : no
                 */

                private double confidence;
                private String value;

                public double getConfidence() {
                    return confidence;
                }

                public void setConfidence(double confidence) {
                    this.confidence = confidence;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class FaceIQABean {
                /**
                 * detectQuality : 0
                 * pointsQuality : 0.921875
                 * eyeDistance : 72.895668
                 * colorful : 1
                 * grayScale : 140
                 * grayMean : 128.238754
                 * grayVar : 35.99176
                 * clearity : 0.7
                 * posePitch : 7.328125
                 * poseRoll : -16.256094
                 * poseYaw : -6.1875
                 * poseConf : 0
                 * frontal : 0
                 * uncovered : 1
                 * totalQuality : 0.654121
                 */

                private int detectQuality;
                private double pointsQuality;
                private double eyeDistance;
                private int colorful;
                private int grayScale;
                private double grayMean;
                private double grayVar;
                private double clearity;
                private double posePitch;
                private double poseRoll;
                private double poseYaw;
                private int poseConf;
                private int frontal;
                private int uncovered;
                private double totalQuality;

                public int getDetectQuality() {
                    return detectQuality;
                }

                public void setDetectQuality(int detectQuality) {
                    this.detectQuality = detectQuality;
                }

                public double getPointsQuality() {
                    return pointsQuality;
                }

                public void setPointsQuality(double pointsQuality) {
                    this.pointsQuality = pointsQuality;
                }

                public double getEyeDistance() {
                    return eyeDistance;
                }

                public void setEyeDistance(double eyeDistance) {
                    this.eyeDistance = eyeDistance;
                }

                public int getColorful() {
                    return colorful;
                }

                public void setColorful(int colorful) {
                    this.colorful = colorful;
                }

                public int getGrayScale() {
                    return grayScale;
                }

                public void setGrayScale(int grayScale) {
                    this.grayScale = grayScale;
                }

                public double getGrayMean() {
                    return grayMean;
                }

                public void setGrayMean(double grayMean) {
                    this.grayMean = grayMean;
                }

                public double getGrayVar() {
                    return grayVar;
                }

                public void setGrayVar(double grayVar) {
                    this.grayVar = grayVar;
                }

                public double getClearity() {
                    return clearity;
                }

                public void setClearity(double clearity) {
                    this.clearity = clearity;
                }

                public double getPosePitch() {
                    return posePitch;
                }

                public void setPosePitch(double posePitch) {
                    this.posePitch = posePitch;
                }

                public double getPoseRoll() {
                    return poseRoll;
                }

                public void setPoseRoll(double poseRoll) {
                    this.poseRoll = poseRoll;
                }

                public double getPoseYaw() {
                    return poseYaw;
                }

                public void setPoseYaw(double poseYaw) {
                    this.poseYaw = poseYaw;
                }

                public int getPoseConf() {
                    return poseConf;
                }

                public void setPoseConf(int poseConf) {
                    this.poseConf = poseConf;
                }

                public int getFrontal() {
                    return frontal;
                }

                public void setFrontal(int frontal) {
                    this.frontal = frontal;
                }

                public int getUncovered() {
                    return uncovered;
                }

                public void setUncovered(int uncovered) {
                    this.uncovered = uncovered;
                }

                public double getTotalQuality() {
                    return totalQuality;
                }

                public void setTotalQuality(double totalQuality) {
                    this.totalQuality = totalQuality;
                }
            }

            public static class IdentifyBean {
                /**
                 * relationId : 1
                 * maxsimilarity : 1
                 * candidate : [{"alarmId":1,"blacklist_id":"19","human_data":[{"face_id":"c625fa4edadb426e92ee5de1f2842933","bkg_picurl":"","face_picurl":"http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=f025202485f03a4bS207FwWhNvgwnLcb0J2jmWrGxFMKnnaJWd1cZY1zw6my3H/JHUfm0aGTkgYgGpUB9sw=&componentId=PIC&serviceType=PICwebapp","face_rect":{"x":0,"y":0,"height":0,"width":0},"similarity":1}],"human_id":"18f79e12-4429-438d-ac13-7f2e561deedd","reserve_field":"{\"version\":\"hcm-1.0\",\"humanName\":\"18f79e12-4429-438d-ac13-7f2e561deedd\",\"humanAge\":0,\"humanMale\":0,\"humanCredtype\":0}","similarity":1}]
                 */

                private int relationId;
                private int maxsimilarity;
                private List<CandidateBean> candidate;

                public int getRelationId() {
                    return relationId;
                }

                public void setRelationId(int relationId) {
                    this.relationId = relationId;
                }

                public int getMaxsimilarity() {
                    return maxsimilarity;
                }

                public void setMaxsimilarity(int maxsimilarity) {
                    this.maxsimilarity = maxsimilarity;
                }

                public List<CandidateBean> getCandidate() {
                    return candidate;
                }

                public void setCandidate(List<CandidateBean> candidate) {
                    this.candidate = candidate;
                }

                public static class CandidateBean {
                    /**
                     * alarmId : 1
                     * blacklist_id : 19
                     * human_data : [{"face_id":"c625fa4edadb426e92ee5de1f2842933","bkg_picurl":"","face_picurl":"http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=f025202485f03a4bS207FwWhNvgwnLcb0J2jmWrGxFMKnnaJWd1cZY1zw6my3H/JHUfm0aGTkgYgGpUB9sw=&componentId=PIC&serviceType=PICwebapp","face_rect":{"x":0,"y":0,"height":0,"width":0},"similarity":1}]
                     * human_id : 18f79e12-4429-438d-ac13-7f2e561deedd
                     * reserve_field : {"version":"hcm-1.0","humanName":"18f79e12-4429-438d-ac13-7f2e561deedd","humanAge":0,"humanMale":0,"humanCredtype":0}
                     * similarity : 1
                     */

                    private int alarmId;
                    private String blacklist_id;
                    private String human_id;
                    private String reserve_field;
                    private int similarity;
                    private List<HumanDataBean> human_data;

                    public int getAlarmId() {
                        return alarmId;
                    }

                    public void setAlarmId(int alarmId) {
                        this.alarmId = alarmId;
                    }

                    public String getBlacklist_id() {
                        return blacklist_id;
                    }

                    public void setBlacklist_id(String blacklist_id) {
                        this.blacklist_id = blacklist_id;
                    }

                    public String getHuman_id() {
                        return human_id;
                    }

                    public void setHuman_id(String human_id) {
                        this.human_id = human_id;
                    }

                    public String getReserve_field() {
                        return reserve_field;
                    }

                    public void setReserve_field(String reserve_field) {
                        this.reserve_field = reserve_field;
                    }

                    public int getSimilarity() {
                        return similarity;
                    }

                    public void setSimilarity(int similarity) {
                        this.similarity = similarity;
                    }

                    public List<HumanDataBean> getHuman_data() {
                        return human_data;
                    }

                    public void setHuman_data(List<HumanDataBean> human_data) {
                        this.human_data = human_data;
                    }

                    public static class HumanDataBean {
                        /**
                         * face_id : c625fa4edadb426e92ee5de1f2842933
                         * bkg_picurl :
                         * face_picurl : http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=f025202485f03a4bS207FwWhNvgwnLcb0J2jmWrGxFMKnnaJWd1cZY1zw6my3H/JHUfm0aGTkgYgGpUB9sw=&componentId=PIC&serviceType=PICwebapp
                         * face_rect : {"x":0,"y":0,"height":0,"width":0}
                         * similarity : 1
                         */

                        private String face_id;
                        private String bkg_picurl;
                        private String face_picurl;
                        private FaceRectBeanX face_rect;
                        private int similarity;

                        public String getFace_id() {
                            return face_id;
                        }

                        public void setFace_id(String face_id) {
                            this.face_id = face_id;
                        }

                        public String getBkg_picurl() {
                            return bkg_picurl;
                        }

                        public void setBkg_picurl(String bkg_picurl) {
                            this.bkg_picurl = bkg_picurl;
                        }

                        public String getFace_picurl() {
                            return face_picurl;
                        }

                        public void setFace_picurl(String face_picurl) {
                            this.face_picurl = face_picurl;
                        }

                        public FaceRectBeanX getFace_rect() {
                            return face_rect;
                        }

                        public void setFace_rect(FaceRectBeanX face_rect) {
                            this.face_rect = face_rect;
                        }

                        public int getSimilarity() {
                            return similarity;
                        }

                        public void setSimilarity(int similarity) {
                            this.similarity = similarity;
                        }

                        public static class FaceRectBeanX {
                            /**
                             * x : 0
                             * y : 0
                             * height : 0
                             * width : 0
                             */

                            private int x;
                            private int y;
                            private int height;
                            private int width;

                            public int getX() {
                                return x;
                            }

                            public void setX(int x) {
                                this.x = x;
                            }

                            public int getY() {
                                return y;
                            }

                            public void setY(int y) {
                                this.y = y;
                            }

                            public int getHeight() {
                                return height;
                            }

                            public void setHeight(int height) {
                                this.height = height;
                            }

                            public int getWidth() {
                                return width;
                            }

                            public void setWidth(int width) {
                                this.width = width;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String x="{\"ipAddress\":\"10.20.84.151\",\"dateTime\":\"2019-05-29T09:43:38Z\",\"activePostCount\":1,\"eventType\":\"captureResult\",\"eventState\":\"active\",\"eventDescription\":\"captureLibResult\",\"captureLibResult\":[{\"errorCode\":1,\"errorMsg\":\"ok\",\"image\":\"http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=8f250a04d9b9ca19Lpnm5XQk1YqnisOgmNhRojrU+ZFUCId9Doq9xAVV2c8cUGIty4gNtJJriV7l4QecP74=&componentId=PIC&serviceType=PICwebapp\",\"traceUuid\":\"123456445645611\",\"traceIdx\":1,\"faces\":[{\"faceId\":1,\"faceRect\":{\"x\":0.309211,\"y\":0.254072,\"width\":0.41886,\"height\":0.312704},\"faceMark\":{\"leftEye\":{\"x\":0.470873,\"y\":0.33726},\"rightEye\":{\"x\":0.624341,\"y\":0.370494},\"leftMouth\":{\"x\":0.441755,\"y\":0.471769},\"rightMouth\":{\"x\":0.564235,\"y\":0.49584},\"noseTip\":{\"x\":0.535732,\"y\":0.410261}},\"recommendFaceRect\":{\"x\":0,\"y\":0,\"width\":1,\"height\":0.938111},\"facePose\":{\"pitch\":7.328125,\"roll\":-16.256094,\"yaw\":-6.1875,\"confidence\":0},\"age\":{\"range\":5,\"value\":25,\"ageGroup\":\"young\"},\"gender\":{\"confidence\":0.998976,\"value\":\"male\"},\"glass\":{\"confidence\":0.999484,\"value\":\"yes\"},\"smile\":{\"confidence\":0.999637,\"value\":\"yes\"},\"ethnic\":{\"confidence\":0.999996,\"value\":\"no\"},\"modeldata\":\"SElLREZSNDIxMTBYAAAAAN3wLkLw8v4e8cAh8uLQIQPrLu/eAzAfMNDQ0u8jBCBQLzEiD/8yIR/wIAEU4hIBACABHQEDEPP+EPIPIMsVHsEAACAiECAPwQKx/RAAAuQO7xAB/w4SHx4s4TDSDr4v0QI9QC7x8NH9OhMc8RIjMS7eD/EvIO7QAfMe8OHkBNQA7gAxEP/Q0gMuEf4REQIBMcf7MQ4C/wAR/b/+BN7A7Pw0EgP+Hj8QEB4DEQ8iAD4UAB8O/h7xQRFRzx/iHx8P8//v7dIV7g8PAA8e5OPgA+/zHR8uXQAxATDy/yNAb+LyMSIDAhE+HtMeHtMQ4R8S4PDg0hIOAPL+7xLr8RAODP0i8OAw8A5NLf/+LTEDEREvEAAC7wDSAf0OHD8OMRD+zxEx0CHfDuLe8D4AEMEA4TQAQxHw7wLg/+/PAdEe7xEAH/4w3/1DDRHg7vEG4f0LsAAiAg7x8RAdMwLeAf7hEeK9HsATMD8uDdAOA/sg0gEvUhDeMm7iJO8PLu8QLh1MEAMvER9N0BAy8QLV9PLc8gAd/vHyAOAF8h0v8mE94A8gEEEA/tMgHvPAMQEt8wz/E1Mu7RDuT/0SL/8dAPEQLQDeAPThIQ4TBP1A3hQc0M7QMSEhHyDB/uDQ/y0v/0AfMvLB/w/hDg3x7xQu8vHs4CMf/d/eAODPDh/8sh7hAu7w\",\"identify\":[{\"relationId\":1,\"maxsimilarity\":1,\"candidate\":[{\"alarmId\":1,\"blacklist_id\":\"19\",\"human_data\":[{\"face_id\":\"c625fa4edadb426e92ee5de1f2842933\",\"bkg_picurl\":\"\",\"face_picurl\":\"http://10.33.29.154:9521/storageServices/v1/datas/5FE0B870-B755-4132-A8D2-9654483E4394?noJson&token=f025202485f03a4bS207FwWhNvgwnLcb0J2jmWrGxFMKnnaJWd1cZY1zw6my3H/JHUfm0aGTkgYgGpUB9sw=&componentId=PIC&serviceType=PICwebapp\",\"face_rect\":{\"x\":0,\"y\":0,\"height\":0,\"width\":0},\"similarity\":1}],\"human_id\":\"18f79e12-4429-438d-ac13-7f2e561deedd\",\"reserve_field\":\"{\\\"version\\\":\\\"hcm-1.0\\\",\\\"humanName\\\":\\\"18f79e12-4429-438d-ac13-7f2e561deedd\\\",\\\"humanAge\\\":0,\\\"humanMale\\\":0,\\\"humanCredtype\\\":0}\",\"similarity\":1}]}],\"faceIQA\":{\"detectQuality\":0,\"pointsQuality\":0.921875,\"eyeDistance\":72.895668,\"colorful\":1,\"grayScale\":140,\"grayMean\":128.238754,\"grayVar\":35.99176,\"clearity\":0.55,\"posePitch\":7.328125,\"poseRoll\":-16.256094,\"poseYaw\":-6.1875,\"poseConf\":0,\"frontal\":0,\"uncovered\":1,\"totalQuality\":0.560675}}]}]}";
        ObjectMapper objectMapper=new ObjectMapper();
        Tst tst= objectMapper.readValue(x,Tst.class);

    }
}
