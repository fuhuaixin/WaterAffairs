package com.fhx.wateraffairs.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

public class PatrolRecordSectionBean extends SectionEntity<PatrolRecordBean> {
    public PatrolRecordSectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public PatrolRecordSectionBean(PatrolRecordBean patrolRecordBean) {
        super(patrolRecordBean);
    }
}
