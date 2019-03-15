# Z90 Android Pos Library with React Native
This library only supports Android and works with Select Android pos only

# Installation
> `$ yarn add react-native-pos`
> `$ react-native link`

# Usage
```jsx
import Pos from 'react-native-pos';

function PosInterface() {
	const print = () => {
		Pos.getPrinterStatus()
		Pos.setBoldFont();
		Pos.setCenterAlign();
		Pos.setFontSize(32);
		Pos.addText('Hello World');
		Pos.addQRCode(JSON.stringify({ url: 'https://honeyguideapps.com' }));
		const res = await Pos.print();
		if (!res) {
			alert('Out of paper');
		}
	}
}
```
# Available Status Values
Use `getPrinterStatus`.

```
int SDK_OK = 0;
int SDK_ERROR = -1001;
int SDK_PARAMERR = -1002;
int SDK_TIMEOUT = -1003;
int SDK_RECV_DATA_ERROR = -1004;
int SDK_ICC_BASE_ERR = -1200;
int SDK_ICC_ERROR = -1201;
int SDK_ICC_PARAM_ERROR = -1202;
int SDK_ICC_NO_CARD = -1203;
int SDK_ICC_NO_RESP = -1204;
int SDK_ICC_COMM_ERR = -1205;
int SDK_ICC_RESP_ERR = -1206;
int SDK_ICC_NO_POWER_ON = -1207;
int SDK_RF_BASE_ERR = -1300;
int SDK_RF_ERROR = -1301;
int SDK_RF_PARAM_ERROR = -1302;
int SDK_RF_ERR_NOCARD = -1303;
int SDK_RF_ERR_CARD_CONFLICT = -1304;
int SDK_RF_TIME_OUT = -1305;
int SDK_RF_PROTOCOL_ERROR = -1306;
int SDK_RF_TRANSMISSION_ERROR = -1307;
int SDK_MAG_BASE_ERR = -1100;
int SDK_MAG_ERROR = -1101;
int SDK_MAG_PARAM_ERROR = -1102;
int SDK_MAG_NO_BRUSH = -1103;
int SDK_PRN_BASE_ERR = -1400;
int SDK_PRN_ERROR = -1401;
int SDK_PRN_PARAM_ERROR = -1402;
int SDK_PRN_STATUS_PAPEROUT = -1403;
int SDK_PRN_STATUS_TOOHEAT = -1404;
int SDK_PRN_STATUS_FAULT = -1405;
int SDK_PRN_STATUS_PRINTING = -1406;
int SDK_PAD_BASE_ERR = -1500;
int SDK_PAD_ERR_NOPIN = -1510;
int SDK_PAD_ERR_CANCEL = -1511;
int SDK_PAD_ERR_TIMEOUT = -1512;
int SDK_PAD_ERR_NEED_WAIT = -1513;
int SDK_PAD_ERR_DUPLI_KEY = -1514;
int SDK_PAD_ERR_INVALID_INDEX = -1515;
int SDK_PAD_ERR_NOTSET_KEY = -1516;
int SDK_PAD_ERR_EXCEPTION = -1517;
```