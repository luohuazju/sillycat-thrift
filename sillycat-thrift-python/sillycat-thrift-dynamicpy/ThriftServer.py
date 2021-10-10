import thriftpy2
from thriftpy2.rpc import make_server

hello_thrift = thriftpy2.load("HelloService.thrift", module_name="hello_thrift")


class HelloServiceHandler(object):

    def sayHello(self, name):
        print("received name parameter " + str(name))
        return "invoke thrift server with name " + str(name)


def main():
    server = make_server(hello_thrift.HelloService, HelloServiceHandler(),
                         '127.0.0.1', 6666)
    print("service running with 127.0.0.1:6666")
    server.serve()


if __name__ == '__main__':
    main()
