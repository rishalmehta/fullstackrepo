
FROM node
WORKDIR /app
COPY package.json /app
RUN npm install
COPY . /app
CMD node switchcase.js
EXPOSE 3000