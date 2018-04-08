package com.vincit.seatmapper

import grails.converters.JSON

class ActionController {
    ActionService actionService

    def randomize() {
        def roomList = Room.list()
        def seatConsumerList = SeatConsumer.list()
        def finalRoomList = actionService.getRandomizedSeats(roomList, seatConsumerList)
        render finalRoomList as JSON
    }

    def initialize() {
        Room.deleteAll(Room.list())
        SeatConsumer.deleteAll(SeatConsumer.list())
        actionService.initialize()
        def returnMap = [status:"Initialize complete"]
        render returnMap as JSON
    }
}
