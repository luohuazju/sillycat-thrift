import sys
sys.path.append('./gen-py')

from HelloService import HelloService
from HelloService.ttypes import *
from HelloService.constants import *
from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

try:
    # socket
    transport = TSocket.TSocket('localhost', 6666)
    # buffering
    transport = TTransport.TBufferedTransport(transport)
    # protocol
    protocol = TBinaryProtocol.TBinaryProtocol(transport)
    # create a client to use the protocol
    client = HelloService.Client(protocol)
    # connect
    transport.open()
    msg = client.sayHello('kiko')
    print(msg)
    transport.close()
except Thrift.TException:
    print("error happen")
