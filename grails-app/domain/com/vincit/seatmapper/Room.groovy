package com.vincit.seatmapper

class Room {

    Integer seats
    Integer currentSeats
    String description
    Integer category
    List<SeatConsumer> seatUsageList = new ArrayList<>()

    def addConsumer(SeatConsumer consumer)
    {
        seatUsageList.add(consumer)
        currentSeats -=consumer.count
    }

    @Override
    String toString()
    {
        return "Room $id, $description : $seatUsageList"
    }
    static constraints = {
    }

    static transients = ['seatUsageList', 'currentSeats']
}
