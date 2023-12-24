package com.mashibing.component;

import com.alibaba.fastjson.JSON;
import com.mashibing.component.entity.ComponentEntity;
import com.mashibing.component.service.OrgComponent;
import com.mashibing.component.service.TeamComponent;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamClient {
    public static void main(String[] args) {
        String jsonOrgStr = "[" +
                "{\"id\":\"9998\",\"name\":\"总行\",\"type\":\"H\",\"supId\":\"\"}," +
                "{\"id\":\"0798\",\"name\":\"深圳\",\"type\":\"B\",\"supId\":\"9998\"}," +
                "{\"id\":\"07981\",\"name\":\"罗湖\",\"type\":\"B2\",\"supId\":\"0798\"}," +
                "{\"id\":\"0799\",\"name\":\"广州\",\"type\":\"B\",\"supId\":\"9998\"}" +
                "]";

        String jsonTeamStr = "[" +
                "{\"id\":\"T07981\",\"name\":\"深圳团队\",\"type\":\"C\",\"supId\":\"07981\"}," +
                "{\"id\":\"T07982\",\"name\":\"深圳团队\",\"type\":\"P\",\"supId\":\"07981\"}," +
                "{\"id\":\"T0799\",\"name\":\"广州团队\",\"type\":\"C\",\"supId\":\"0799\"}" +
                "]";
        List<ComponentEntity> teamList = JSON.parseArray(jsonTeamStr, ComponentEntity.class);

        List<String> orgAuth = new ArrayList<>(Arrays.asList("9998","0798","07981","0799"));
        List<String> teamAuth = new ArrayList<>(Arrays.asList("T07981","T07982","T0799"));
        List<String> teamType = new ArrayList<>(Arrays.asList("C","D","P"));
        List<OrgComponent> componentList = new ArrayList<>();

        String showType = "C"; // 机构树显示到那层

        if (CollectionUtils.isNotEmpty(teamAuth)) {
            List<ComponentEntity> orgList = JSON.parseArray(jsonOrgStr, ComponentEntity.class);

            ComponentEntity rootOrg = orgList.get(0);
            OrgComponent root = new OrgComponent(rootOrg);
            componentList.add(root);
            for (ComponentEntity org : orgList) {
                int supIndex = orgAuth.indexOf(org.getSupId());
                if (supIndex >= 0) {
                    OrgComponent supComponent = componentList.get(supIndex);
                    OrgComponent curComponent = new OrgComponent(org);
                    supComponent.add(curComponent);
                    componentList.add(curComponent);
                }
            }

            if (CollectionUtils.isNotEmpty(teamList)) {
                for (ComponentEntity team : teamList) {
                    int supIndex = orgAuth.indexOf(team.getSupId());
                    if (supIndex >= 0) {
                        OrgComponent supComponent = componentList.get(supIndex);
                        TeamComponent curComponent = new TeamComponent(team);
                        supComponent.add(curComponent);
                    }
                }
            }
            System.out.println(JSON.toJSONString(root));
        }
    }
}
