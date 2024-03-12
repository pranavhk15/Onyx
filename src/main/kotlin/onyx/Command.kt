package onyx
import com.github.stivais.commodore.Node
import com.github.stivais.commodore.utils.LegacyCommodore
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.BlockPos


class Command {
    val command = commodore("command") {
        runs { value: Long ->
            println(value)
        }
    }
}

val commodoreHandler = LegacyCommodore()

fun commodore(vararg string: String, block: Node.() -> Unit): CommandBase {
    return object : CommandBase() {

        private val root = Node(string[0])

        init {
            root.block()
            root.build()
            commodoreHandler.register(root)
        }

        override fun getCommandName(): String = string[0]

        override fun getCommandAliases(): List<String> = string.drop(1)

        override fun getCommandUsage(sender: ICommandSender?): String = "/${commandName}"

        override fun getRequiredPermissionLevel(): Int = 0

        override fun processCommand(sender: ICommandSender, args: Array<out String>) {
            commodoreHandler.execute(args.fix(), root)
        }

        override fun addTabCompletionOptions(
                sender: ICommandSender,
                args: Array<out String>,
                pos: BlockPos
        ): List<String> {
            return commodoreHandler.completions(args.fix())
        }

        inline fun Array<out String>.fix(): String {
            return if (this.isEmpty()) commandName else "$commandName ${this.joinToString(separator = " ")}"
        }
    }
}

