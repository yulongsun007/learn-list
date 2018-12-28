1.
Exception in thread "main" java.lang.IllegalArgumentException
	at java.nio.channels.spi.AbstractSelectableChannel.register(AbstractSelectableChannel.java:199)
	at java.nio.channels.SelectableChannel.register(SelectableChannel.java:280)
	at JdkNioServerSocketChannelCase.main(JdkNioServerSocketChannelCase.java:30)
解决
 socketChannel.configureBlocking(false);

2.

