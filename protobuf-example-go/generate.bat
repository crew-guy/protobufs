go get -u github.com/golang/protobuf/protoc-gen-go

protoc.exe -I src\ --go_out=src\ src\simple\simple.proto