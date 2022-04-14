keytool -genkey\
  -v \
  -keystore keystore.p12 \
  -alias production\
  -keyalg RSA \
  -keysize 2048 \
  -storetype pkcs12 \
  -validity 10000