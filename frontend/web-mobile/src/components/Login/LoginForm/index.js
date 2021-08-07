import { FacebookFilled, GoogleSquareFilled } from "@ant-design/icons";
import '../LoginForm/index.scss';
import { useForm } from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
const phoneRegExp = /(84|0[3|5|7|8|9])+([0-9]{8,9})\b/g;
const schema = yup.object().shape({
    tendn: yup.string().required("Vui lòng điền số điện thoại!").matches(phoneRegExp, "Số điện thoại không đúng định dạng!"),
    matkhau: yup.string().required("Vui lòng điền mật khẩu!").min(6, "Mật khẩu phải lớn hơn 6 kí tự!").max(15, "Mật khẩu không được quá 15 kí tự!")
});
function LoginForm(props) {
    const { onSubmit } = props;
    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(schema),
    }
    )
    const color = {
        backgroundColor: 'white',
        color: 'red',
        fontSize: '18px'
    };
    const submit = (data) => {
        if (onSubmit)
            onSubmit(data);
    }
    return (
        <div className="login">
            <div className="login__title">Đăng nhập</div>
            <div className="login__input">
                <form onSubmit={handleSubmit(submit)}>
                    <input type="text" placeholder="Số điện thoại" {...register('tendn')}></input>
                    <p>{errors.tendn?.message}</p>
                    <input type="password" placeholder="Mật khẩu" {...register('matkhau')}></input>
                    <p>{errors.matkhau?.message}</p>
                    <button className="login__btn" type="submit" >Đăng nhập</button>
                </form>
            </div>
            <div className="login__reset">Quên mật khẩu</div>
            <div className="login__or">
                <div style={{ height: '1px', width: '100%', backgroundColor: '#dcdcdc' }}></div>
                <span>Hoặc</span>
                <div style={{ height: '1px', width: '100%', backgroundColor: '#dcdcdc' }}></div>
            </div>
            <div className="login__icon">
                <button className="login__icon-des">
                    <FacebookFilled style={color}></FacebookFilled>
                    <div className="login__icon-title">Facebook</div>
                </button>
                <button className="login__icon-des">
                    <GoogleSquareFilled style={color} />
                    <div className="login__icon-title">Google</div>
                </button>
            </div>
            <div className="login__not-accout">
                <p>Bạn mới biết đến Shop? <span>Đăng ký</span></p>
            </div>
        </div>
    );
}
export default LoginForm;