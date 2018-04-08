package com.vincit.seatmapper

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SeatConsumerController {

    SeatConsumerService seatConsumerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond seatConsumerService.list(params), model:[seatConsumerCount: seatConsumerService.count()]
    }

    def show(Long id) {
        respond seatConsumerService.get(id)
    }

    def create() {
        respond new SeatConsumer(params)
    }

    def save(SeatConsumer seatConsumer) {
        if (seatConsumer == null) {
            notFound()
            return
        }

        try {
            seatConsumerService.save(seatConsumer)
        } catch (ValidationException e) {
            respond seatConsumer.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'seatConsumer.label', default: 'SeatConsumer'), seatConsumer.id])
                redirect seatConsumer
            }
            '*' { respond seatConsumer, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond seatConsumerService.get(id)
    }

    def update(SeatConsumer seatConsumer) {
        if (seatConsumer == null) {
            notFound()
            return
        }

        try {
            seatConsumerService.save(seatConsumer)
        } catch (ValidationException e) {
            respond seatConsumer.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'seatConsumer.label', default: 'SeatConsumer'), seatConsumer.id])
                redirect seatConsumer
            }
            '*'{ respond seatConsumer, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        seatConsumerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'seatConsumer.label', default: 'SeatConsumer'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'seatConsumer.label', default: 'SeatConsumer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
