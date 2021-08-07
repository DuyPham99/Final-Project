import { FacebookFilled, GoogleSquareFilled } from "@ant-design/icons";
import '../LoginForm/index.scss';
import { useForm } from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import logodn from '../../../assets/images/logolaptop.png';
import { NavLink } from "react-router-dom";
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
    const submit = (data) => {
        if (onSubmit)
            onSubmit(data);
    }
    return (
        <div className="login">
            <div className="login__logo"><img className="login__logo-img" src={logodn} alt="logo">
            </img></div>
            <div className="login__title">Đăng nhập</div>
            <div className="login__input">
                <form onSubmit={handleSubmit(submit)}>
                    <input type="text" placeholder="Số điện thoại" {...register('tendn')}></input>
                    <p>{errors.tendn?.message}</p>
                    <input type="password" placeholder="Mật khẩu" {...register('matkhau')}></input>
                    <p>{errors.matkhau?.message}</p>
                    <div className="login__btn-sb">
                        <button className="login__btn" type="submit" >Đăng nhập</button>
                    </div>
                </form>
            </div>
            <NavLink to='/quenmatkhau' className="login__pass">
                <div className="login__reset">Quên mật khẩu</div>
            </NavLink>
            <div className="login__or">
                <span>Hoặc</span>
            </div>
            <div className="login__icon">
                <button className="login__icon-des">
                    <FacebookFilled style={{ color: 'darkslateblue', fontSize: '18px' }}></FacebookFilled>
                    <div className="login__icon-title">Đăng nhập băng facebook</div>
                </button>
                <button className="login__icon-des">
                    <GoogleSquareFilled style={{ color: 'chocolate', fontSize: '18px' }} />
                    <div className="login__icon-title">Đăng nhập bằng google</div>
                </button>
            </div>
            <NavLink to="/dangki" >
                <div className="login__not-accout">
                    Đăng ký tài khoản mới
                </div>
            </NavLink>
        </div>
    );
}
export default LoginForm;