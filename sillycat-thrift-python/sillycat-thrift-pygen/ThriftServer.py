import sys
sys.path.append('./gen-py')

from HelloService import HelloService
from HelloService.ttypes import *
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer


class HelloServiceHandler:

    def sayHello(self, name):
        print("invoke and call service")
        return "say hello from python " + name


handler = HelloServiceHandler()
processor = HelloService.Processor(handler)
transport = TSocket.TServerSocket("127.0.0.1", 6666)
tfactory = TTransport.TBufferedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()
server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)
print("starting python server...")
print("127.0.0.1:6666")
server.serve()
