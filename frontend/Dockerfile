# Set base docker image
FROM node:17.2-alpine
# Set up workspace on docker container
WORKDIR /app
# Copy all files to docker container
COPY . .
# Install dependencies
RUN [ "npm","run", "build" ]
# Expose app port
EXPOSE 8080
CMD [ "npm","run","serve" ]