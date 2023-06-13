package com.qp.ots.prs;

import com.qp.ots.utils.CmmnUtils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum EScheme {
    BATTERY40_A_STR("产品"),
    BATTERY40_B_DOUBLE("本周产能-万片"),
    BATTERY40_C_DOUBLE("本周产能-MW"),
    BATTERY40_D_LONG("本月计划产量-万片"),
    BATTERY40_E_LONG("本月计划产量-MW"),
    BATTERY40_F_LONG("本周实际产量-万片"),
    BATTERY40_G_LONG("本周实际产量-MW"),
    BATTERY40_H_PER_DOUBLE("本月累计产量-计划完成率"),
    BATTERY40_I_LONG("本月计划销量-万片"),
    BATTERY40_J_LONG("本月计划销量-MW"),
    BATTERY40_K_LONG("本周实际销量-万片"),
    BATTERY40_L_LONG("本周实际销量-MW"),
    BATTERY40_M_PER_DOUBLE("本月累计销量-计划完成率"),
    BATTERY40_N_STR("含税销售单价（自产：元/W，加工：元/片）"),
    BATTERY40_O_LONG("含税销售收入（万元）"),
    BATTERY40_P_LONG("库存量-万片"),
    BATTERY40_Q_LONG("库存量-MW"),

    BATTERY41_A_STR("材料类别"),
    BATTERY41_B_STR("单位"),
    BATTERY41_C_LONG("采购入库量"),
    BATTERY41_D_DOUBLE("单价（含税）"),
    BATTERY41_E_LONG("采购金额（万元）"),
    BATTERY41_F_LONG("库存数量"),
    BATTERY41_G_LONG("预计可使用天数"),

    BATTERY42_A_STR("产品"),
    BATTERY42_B_PER_DOUBLE("良率"),
    BATTERY42_C_PER_DOUBLE("转换效率"),

    NM10_A_STR("产品"),
    NM10_B_LONG("本周产能-（万㎡）"),
    NM10_C_LONG("本月计划产量-（万㎡）"),
    NM10_D_LONG("本周实际产量-（万㎡）"),
    NM10_E_PER_DOUBLE("本月累计产量-计划完成率"),
    NM10_F_LONG("本月计划销量-（万㎡）"),
    NM10_G_LONG("本周实际销量-（万㎡）"),
    NM10_H_PER_DOUBLE("本月累计销量-计划完成率"),
    NM10_I_DOUBLE("含税销售单价-（元/㎡）"),
    NM10_J_LONG("含税销售收入-（万元）"),

    NM11_A_STR("原材料"),
    NM11_B_LONG("库存量-（万㎡）"),
    NM11_C_LONG("备货天数"),

    BUA20_A_STR("业务主体"),
    BUA20_B_LONG("本月计划开发量（MW）"),
    BUA20_C_DOUBLE("本周实际开发量（MW）"),
    BUA20_D_PER_DOUBLE("本月累计开发量-计划完成率"),
    BUA20_E_DOUBLE("本月计划并网量（MW）"),
    BUA20_F_DOUBLE("本周实际并网量(MW）"),
    BUA20_G_PER_DOUBLE("本月累计并网量-计划完成率"),

    BUA21_A_STR("材料类别"),
    BUA21_B_STR("单位"),
    BUA21_C_DOUBLE("内部采购量（不含瞩日）"),
    BUA21_D_LONG("内部采购金额（不含瞩日）（万元）"),
    BUA21_E_DOUBLE("瞩日采购量"),
    BUA21_F_LONG("瞩日采购金额（万元）"),
    BUA21_G_DOUBLE("外部采购量"),
    BUA21_H_LONG("外部采购金额（万元）"),
    BUA21_I_LONG("期末库存量"),
    BUA21_J_LONG("期末库存金额（万元）"),

    BUA22_A_STR("区域"),
    BUA22_B_LONG("组件-在建数量（MW）"),
    BUA22_C_LONG("组件-在建金额（万元）"),
    BUA22_D_LONG("组件-库存数量（MW）"),
    BUA22_E_LONG("组件-库存金额（万元）"),
    BUA22_F_LONG("逆变器-在建数量（MW）"),
    BUA22_G_LONG("逆变器-在建金额（万元）"),
    BUA22_H_LONG("逆变器-库存数量（MW）"),
    BUA22_I_LONG("逆变器-库存金额（万元）"),
    BUA22_J_LONG("配电箱-在建数量（MW）"),
    BUA22_K_LONG("配电箱-在建金额（万元）"),
    BUA22_L_LONG("配电箱-库存数量（MW）"),
    BUA22_M_LONG("配电箱-库存金额（万元）"),

    BUA23_A_STR(""), //数量列
    BUA23_B_LONG("期初异常卡数"),
    BUA23_C_LONG("本期新增"),
    BUA23_D_LONG("本期处理"),
    BUA23_E_LONG("期末异常卡数"),

    CM30_A_STR("产品"),
    CM30_B_LONG("本周产能-万片"),
    CM30_C_LONG("本周产能-MW"),
    CM30_D_LONG("本月计划产量-万片"),
    CM30_E_LONG("本月计划产量-MW"),
    CM30_F_LONG("本周实际产量-万片"),
    CM30_G_LONG("本周实际产量-MW"),
    CM30_H_PER_DOUBLE("本月累计产量-计划完成率"),
    CM30_I_LONG("本月计划销量-万片"),
    CM30_J_LONG("本月计划销量-MW"),
    CM30_K_LONG("本周实际销量-万片"),
    CM30_L_LONG("本周实际销量-MW"),
    CM30_M_PER_DOUBLE("本月累计销量-计划完成率"),
    CM30_N_DOUBLE("含税销售单价（自产：元/W，加工：元/片）"),
    CM30_O_DOUBLE("含税销售收入（万元）"),
    CM30_P_LONG("库存量-万片"),
    CM30_Q_LONG("库存量-MW"),

    CM31_A_STR("材料类别"),
    CM31_B_STR("单位"),
    CM31_C_LONG("采购入库量"),
    CM31_D_DOUBLE("单价（含税）"),
    CM31_E_LONG("采购金额（万元）"),
    CM31_F_STR("库存数量"),
    CM31_G_LONG("预计可使用天数"),

    CM32_A_STR("产品"),
    CM32_B_PER_DOUBLE("良率"),
    CM32_C_PER_DOUBLE("转换效率"),

    END("END");

    private final String value;

    EScheme(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static List<EScheme> schemes(String prefix){
        EScheme[] values = EScheme.values();
        List<EScheme> r = new LinkedList<>();
        for(EScheme scheme : values){
            if(scheme.name().startsWith(prefix)){
                r.add(scheme);
            }
        }
        return r;
    }

    public static List<EScheme> schemes(Integer type, Integer category){
        List<String> list = Arrays.asList(
                "[4_40]BATTERY40",
                "[4_41]BATTERY41",
                "[4_42]BATTERY42",

                "[1_10]NM10",
                "[1_11]NM11",

                "[2_20]BUA20",
                "[2_21]BUA21",
                "[2_22]BUA22",
                "[2_23]BUA23",

                "[3_30]CM30",
                "[3_31]CM31",
                "[3_32]CM32",

                "END"
        );
        String keyword = String.format("[%d_%d]",type,category);
        for(String s : list){
            if(s.startsWith(keyword)){
                return schemes(s.substring(keyword.length()));
            }
        }
        return new LinkedList<>();
    }

    public static Object parseValue(String name, String value){
        if(name.endsWith("_LONG")){
            if(value!=null){
                if(!value.startsWith("/")){
                    //去掉[,]
                    value = value.replace(",","");
                    Double v = CmmnUtils.asDouble(value);
                    if(v!=null){
                        return v.longValue();
                    }
                }
            }
        }
        if(name.endsWith("_DOUBLE")){
            if(value!=null){
                if(!value.startsWith("/")){
                    boolean per = false;
                    if(value.endsWith("%")){//去掉%
                        value = value.substring(0,value.length()-1);
                        per = true;
                    }
                    //去掉[,]
                    value = value.replace(",","");
                    Double v = CmmnUtils.asDouble(value);
                    if(v!=null){
                        if(per){
                            return v/100;
                        }
                        return v;
                    }
                }
            }
        }
        if(name.endsWith("_STR")){
            return value;
        }
        if(value!=null){
            if(value.startsWith("/")){
                return value;
            }
        }
        return null;
    }

    public static String asString(String name, Object value){
        if(value!=null){
            if(name.endsWith("_LONG")){
                if(!String.valueOf(value).startsWith("/")) {
                    DecimalFormat decimalFormat = new DecimalFormat(",###");
                    return decimalFormat.format(value);
                }
            }
            if(name.endsWith("_PER_DOUBLE")){
                if(!String.valueOf(value).startsWith("/")) {
                    Double v = CmmnUtils.asDouble(String.valueOf(value));
                    if (v != null) {
                        String s = CmmnUtils.prettyDouble(v * 100);
                        if (s != null) {
                            return s.concat("%");
                        }
                    }
                }
            }
            if(name.endsWith("_DOUBLE")){
                if(!String.valueOf(value).startsWith("/")) {
                    DecimalFormat decimalFormat = new DecimalFormat(",###.####");
                    return decimalFormat.format(value);
                }
            }
            if(name.endsWith("_STR")){
                String s = String.valueOf(value);
                if(s.endsWith(".0")){
                    s = s.substring(0,s.length()-2);
                }
                return s;
            }
            if(String.valueOf(value).startsWith("/")) {
                return String.valueOf(value);
            }
        }
        return "/";
    }

    public Object parseValue(String value){
        return parseValue(name(),value);
    }

    public String asString(Object value){
        return asString(name(),value);
    }
}