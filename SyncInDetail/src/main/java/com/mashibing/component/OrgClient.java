package com.mashibing.component;

import com.alibaba.fastjson.JSON;
import com.mashibing.component.entity.ComponentEntity;
import com.mashibing.component.service.OrgComponent;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrgClient {
    public static void main(String[] args) {
        String jsonOrgStr = "[" +
                "{\"id\":\"9998\",\"name\":\"总行\",\"type\":\"H\",\"supId\":\"\"}," +
                "{\"id\":\"0798\",\"name\":\"深圳\",\"type\":\"B\",\"supId\":\"9998\"}," +
                "{\"id\":\"07981\",\"name\":\"罗湖\",\"type\":\"B2\",\"supId\":\"0798\"}," +
                "{\"id\":\"0799\",\"name\":\"广州\",\"type\":\"B\",\"supId\":\"9998\"}," +
                "{\"id\":\"0800\",\"name\":\"上海\",\"type\":\"B\",\"supId\":\"9998\"}" +
                "]";

        List<String> orgAuth = new ArrayList<>(Arrays.asList("9998","0798","07981","0799","0800"));
        List<String> orgType = new ArrayList<>(Arrays.asList("H","B","B2","S"));
        List<OrgComponent> componentList = new ArrayList<>();

        String showType = "B"; // 机构树显示到那层
        int lastIndex = StringUtils.isEmpty(showType) ? orgType.size() : orgType.lastIndexOf(showType);

        if (CollectionUtils.isNotEmpty(orgAuth)) {
            List<ComponentEntity> orgList = JSON.parseArray(jsonOrgStr, ComponentEntity.class);

            ComponentEntity rootOrg = orgList.get(0);
            OrgComponent root = new OrgComponent(rootOrg);
            componentList.add(root);
            for (int i = 0 ; i < orgList.size(); i ++) {
                ComponentEntity org = orgList.get(i);
                int supIndex = orgAuth.indexOf(org.getSupId());
                int typeIndex = orgType.lastIndexOf(org.getType());
                if (supIndex >= 0 && typeIndex <= lastIndex) {
                    OrgComponent supComponent = componentList.get(supIndex);
                    OrgComponent curComponent = new OrgComponent(org);
                    supComponent.add(curComponent);
                    componentList.add(curComponent);
                }
            }
            System.out.println(JSON.toJSONString(root));
        }
    }
}
