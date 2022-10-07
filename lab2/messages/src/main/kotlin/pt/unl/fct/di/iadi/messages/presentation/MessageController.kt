package pt.unl.fct.di.iadi.messages.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class MessageController : MessageAPI {

    override fun getAll(mb_id: Long): Collection<MessageListDTO> {
        TODO("Not yet implemented")
    }

    override fun getOne(mb_id: Long, msg_id: Long): Optional<MessageDTO> {
        TODO("Not yet implemented")
    }

    override fun addOne(mb_id: Long, value: MessageCreateDTO) {
        TODO("Not yet implemented")
    }

    override fun updateOne(mb_id: Long, msg_id: Long, message: MessageDTO) {
        TODO("Not yet implemented")
    }

    override fun deleteOne(mb_id: Long, msg_id: Long) {
        TODO("Not yet implemented")
    }

    override fun addMailbox() {
        TODO("Not yet implemented")
    }

    override fun deleteMailbox(mb_id: Long) {
        TODO("Not yet implemented")
    }

    override fun getAllMailboxes(): Collection<MailboxListDTO> {
        TODO("Not yet implemented")
    }

    override fun getMailbox(mb_id: Long): Optional<MailboxDTO> {
        TODO("Not yet implemented")
    }

}