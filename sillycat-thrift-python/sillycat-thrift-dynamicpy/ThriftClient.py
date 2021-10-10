import thriftpy2
from thriftpy2.rpc import make_client

hello_thrift = thriftpy2.load("HelloService.thrift", module_name="hello_thrift")


def main():
    client = make_client(hello_thrift.HelloService, '127.0.0.1', 6666)
    msg = client.sayHello('Hua Luo')
    print(msg)


if __name__ == '__main__':
    main()