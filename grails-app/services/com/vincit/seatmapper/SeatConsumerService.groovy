package com.vincit.seatmapper

import grails.gorm.services.Service

@Service(SeatConsumer)
interface SeatConsumerService {

    SeatConsumer get(Serializable id)

    List<SeatConsumer> list(Map args)

    Long count()

    void delete(Serializable id)

    SeatConsumer save(SeatConsumer seatConsumer)

}