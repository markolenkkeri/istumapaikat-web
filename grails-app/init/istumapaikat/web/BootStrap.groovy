package istumapaikat.web

import com.vincit.seatmapper.Room
import com.vincit.seatmapper.SeatConsumer
import grails.converters.JSON

class BootStrap {
    def actionService

    def init = { servletContext ->
        actionService.initialize()
        JSON.registerObjectMarshaller(Room) {
            def marshallerMap = [
                    "seats":it.seats,
                    "currentSeats":it.currentSeats,
                    "description":it.description,
                    "category":it.category,
                    "seatUsageList":it.seatUsageList
            ]
            return marshallerMap
        }

        JSON.registerObjectMarshaller(SeatConsumer) {
            def marshallerMap = [
                    "count":it.count,
                    "description":it.description,
                    "category":it.category,
                    "strict":it.strict
            ]
            return marshallerMap
        }
    }
    def destroy = {
    }
}
