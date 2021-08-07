import '../Contact/index.scss';
import EmailIcon from '@material-ui/icons/Email';
import PhoneIcon from '@material-ui/icons/Phone';
import DirectionsIcon from '@material-ui/icons/Directions';
import HeadsetIcon from '@material-ui/icons/Headset';
function Contact() {
    const style = {
        backgroundColor: "teal",
        fontSize: "40px",
        padding: "10px",
        borderRadius: "50%"
    }
    return (
        <div className="contact">
            <div className="contact__title">Liên hệ</div>
            <div className="contact__info">
                <iframe title="address" className="contact__map" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.551839773946!2d106.78474021425691!3d10.84556806088067!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752713e927d189%3A0x14478c9f7399b5a8!2zNDQ4LCAyMzEgTMOqIFbEg24gVmnhu4d0LCBUxINuZyBOaMahbiBQaMO6IEEsIFF14bqtbiA5LCBUaMOgbmggcGjhu5EgSOG7kyBDaMOtIE1pbmgsIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1625593572888!5m2!1svi!2s" style={{ width: "600px", height: "500px" }}></iframe>
                <div className="contact__des">
                    <ul className="contact__list">
                        <li className="contact__item">
                            <DirectionsIcon style={style}></DirectionsIcon>
                            <div className="contact__des-title">
                                <p>ADDRESS</p>
                                <span>448/2/33,Lê Văn Việt,Phường Tăng Nhơn Phú A,Quận 9</span>
                            </div>

                        </li>

                        <li className="contact__item">
                            <EmailIcon style={style} />
                            <div className="contact__des-title">
                                <p>EMAIL</p>
                                <span>huytrinh2713@gamil.com</span>
                            </div>

                        </li>
                        <li className="contact__item">
                            <PhoneIcon style={style}> </PhoneIcon>
                            <div className="contact__des-title">
                                <p>HOTLINE</p>
                                <span>0387.112.713</span>
                            </div>

                        </li>
                        <li className="contact__item">
                            <HeadsetIcon style={style} />
                            <div className="contact__des-title">
                                <p>PHẢN HỒI VỀ DỊCH VỤ</p>
                                <span>Mọi phản hồi vui lòng gửi mail về huytrinh2603@gmail.com</span>
                            </div>

                        </li>
                    </ul>
                </div>
            </div>
        </div>
    );
}
export default Contact;