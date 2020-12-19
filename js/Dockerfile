FROM node:12

WORKDIR /usr/src/app
COPY ./package.json ./

RUN npm install
RUN npm install --global http-server

ADD src .

EXPOSE 80

CMD http-server -p 80 -c-1n
