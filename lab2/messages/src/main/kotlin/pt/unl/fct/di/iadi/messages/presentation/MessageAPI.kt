package pt.unl.fct.di.iadi.messages.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.websocket.server.PathParam

@RequestMapping("mailbox")
interface MessageAPI {

    @Operation(summary = "Get all messages")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found all messages", content = [
            (Content(mediaType = "application/json", array = (ArraySchema(schema = Schema(implementation = MessageListDTO::class)))))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()])]
    )
    @GetMapping("{mb_id}/messages")
    fun getAll(@PathVariable mb_id: Long): Collection<MessageListDTO>

    @Operation(summary = "Get one message given an Id")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found the message", content = [
            (Content(mediaType = "application/json", schema = Schema(implementation = MessageDTO::class)))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find the sought message", content = [Content()])]
    )
    @GetMapping("{mb_id}/messages/{msg_id}")
    fun getOne(@PathVariable mb_id: Long, @PathVariable msg_id: Long): Optional<MessageDTO>

    @Operation(summary = "Add one message")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Added the message", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()])]
    )
    @PostMapping("{mb_id}/messages")
    fun addOne(@PathVariable mb_id: Long, @RequestBody value: MessageCreateDTO):Unit

    @Operation(summary = "Update one message")
    @ApiResponses(value = [
        ApiResponse(responseCode = "202", description = "Updated the message", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any message", content = [Content()])]
    )
    @PutMapping("{mb_id}/messages/{msg_id}")
    fun updateOne(@PathVariable mb_id: Long, @PathVariable msg_id: Long, @RequestBody message : MessageDTO):Unit

    @Operation(summary = "Delete one message")
    @ApiResponses(value = [
        ApiResponse(responseCode = "202", description = "Deleted the message", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any message", content = [Content()])]
    )
    @DeleteMapping("{mb_id}/messages/{msg_id}")
    fun deleteOne(@PathVariable mb_id: Long, @PathVariable msg_id: Long):Unit

    @Operation(summary = "Add one mailbox")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Added a mailbox", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()])]
    )
    @PostMapping("")
    fun addMailbox():Unit

    @Operation(summary = "Delete one mailbox")
    @ApiResponses(value = [
        ApiResponse(responseCode = "202", description = "Deleted the mailbox", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any mailbox", content = [Content()])]
    )
    @DeleteMapping("{mb_id}")
    fun deleteMailbox(@PathVariable mb_id: Long):Unit

    @Operation(summary = "Get all mailboxes")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found all mailboxes", content = [
            (Content(mediaType = "application/json", array = (ArraySchema(schema = Schema(implementation = MailboxListDTO::class)))))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()])]
    )
    @GetMapping("")
    fun getAllMailboxes(): Collection<MailboxListDTO>

    @Operation(summary = "Get one mailbox given an Id")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found the mailbox", content = [
            (Content(mediaType = "application/json", schema = Schema(implementation = MailboxDTO::class)))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find the sought mailbox", content = [Content()])]
    )
    @GetMapping("{mb_id}")
    fun getMailbox(@PathVariable mb_id: Long): Optional<MailboxDTO>
}

