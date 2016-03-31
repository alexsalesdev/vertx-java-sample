package com.ourparents.service;

import com.ourparents.util.JooqContext;

import javax.inject.Inject;

/**
 * Created by ASales on 3/14/2016.
 */
public class GeocodeService {

    private JooqContext jooqContext;

    @Inject
    public GeocodeService(JooqContext jooqContext) {
        this.jooqContext = jooqContext;
    }

//    public List<Geocodes> autocompleteTerm(String term) {
//        return jooqContext.getDsl().select().from(com.ourparents.db.tables.Geocodes.GEOCODES)
//                .where(com.ourparents.db.tables.Geocodes.GEOCODES.NAME_KEY.likeIgnoreCase(term + "%"))
//                .orderBy(com.ourparents.db.tables.Geocodes.GEOCODES.PRIORITY.desc())
//                .limit(10)
//                .fetch().into(Geocodes.class);
//    }

}
