package pt.unl.fct.di.iadi.messages.presentation

import io.swagger.v3.oas.annotations.media.Schema


@Schema(description = "A message sent by the system")
data class MessageDTO(
    val id:Long,
    @field:Schema(example = "a@a.org")
    val to:String,
    @field:Schema(example = "a@a.org")
    val cc:String,
    @field:Schema(example = "This message is about...")
    val subject:String,
    @field:Schema(example = "This is the message...")
    val body:String)

@Schema(description = "A system mailbox with messages")
data class MailboxDTO(
    val id:Long,
    @field:Schema(example = "{1,2,3,...}") //Como especificar o tipo dos items do array?
    val messages:List<Long>)


data class MessageCreateDTO(val to:String, val cc:String, val subject:String, val body:String)

data class MessageListDTO(val id:Long, val to:String, val cc:String, val subject:String)

data class MailboxListDTO (val id:Long)

