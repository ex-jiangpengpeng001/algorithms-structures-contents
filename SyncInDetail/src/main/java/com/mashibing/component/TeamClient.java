package com.mashibing.component;

import com.alibaba.fastjson.JSON;
import com.mashibing.component.entity.ComponentEntity;
import com.mashibing.component.service.OrgComponent;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamClient {
    public static void main(String[] args) {
        String jsonOrgStr = "[" +
                "{\"id\":\"9998\",\"name\":\"总行\",\"type\":\"H\",\"supId\":\"\"}," +
                "{\"id\":\"0798\",\"name\":\"深圳\",\"type\":\"B\",\"supId\":\"9998\"}," +
                "{\"id\":\"07981\",\"name\":\"罗湖\",\"type\":\"B2\",\"supId\":\"0798\"}," +
                "{\"id\":\"0799\",\"name\":\"广州\",\"type\":\"B\",\"supId\":\"9998\"}," +
                "{\"id\":\"0800\",\"name\":\"上海\",\"type\":\"B\",\"supId\":\"9998\"}" +
                "]";

        String jsonTeamStr = "[" +
                "{\"id\":\"T07981\",\"name\":\"深圳团队\",\"type\":\"C\",\"supId\":\"07981\"}," +
                "{\"id\":\"T07982\",\"name\":\"深圳团队\",\"type\":\"P\",\"supId\":\"07981\"}," +
                "{\"id\":\"T0799\",\"name\":\"广州团队\",\"type\":\"C\",\"supId\":\"0799\"}" +
                "]";
        List<ComponentEntity> teamList = JSON.parseArray(jsonTeamStr, ComponentEntity.class);

        List<String> teamAuth = new ArrayList<>(Arrays.asList("T07981","T0799"));
        List<String> teamType = new ArrayList<>(Arrays.asList("C","P"));
        List<OrgComponent> componentList = new ArrayList<>();

        String showType = "C"; // 机构树显示到那层

        if (CollectionUtils.isNotEmpty(teamAuth)) {
            List<ComponentEntity> orgList = JSON.parseArray(jsonOrgStr, ComponentEntity.class);

//            ComponentEntity rootOrg = orgList.get(0);
//            OrgComponent root = new OrgComponent(rootOrg);
//            componentList.add(root);
//            for (int i = 0 ; i < orgList.size(); i ++) {
//                ComponentEntity org = orgList.get(i);
//                int supIndex = orgAuth.indexOf(org.getSupId());
//                int typeIndex = orgType.lastIndexOf(org.getType());
//                if (supIndex >= 0 && typeIndex <= lastIndex) {
//                    OrgComponent supComponent = componentList.get(supIndex);
//                    OrgComponent curComponent = new OrgComponent(org);
//                    supComponent.add(curComponent);
//                    componentList.add(curComponent);
//                }
//            }

//            if (CollectionUtils.isNotEmpty(teamList)) {
//                for (ComponentEntity team : teamList) {
//                    int index = orgAuth.indexOf(team.getSupId());
//                    if (index >= 0) {
//                        OrgComponent supComponent = componentList.get(index);
//                        TeamComponent curComponent = new TeamComponent(team);
//                        supComponent.add(curComponent);
//                    }
//                }
//            }
//            System.out.println(JSON.toJSONString(root));
        }
    }
}
