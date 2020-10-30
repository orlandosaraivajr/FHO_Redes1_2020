require 'socket'

hostname = '127.0.0.1'
port = 2000

s = TCPSocket.open(hostname, port)

while line = s.gets
   puts line.chop
end
s.close
