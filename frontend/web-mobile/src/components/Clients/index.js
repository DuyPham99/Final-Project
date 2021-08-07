import '../Clients/index.scss';
import client1 from '../../assets/images/LAVIE-1.jpg';
import client2 from '../../assets/images/EVN-1.jpg';
import client3 from '../../assets/images/NESTLE-1.jpg';
import client4 from '../../assets/images/NUMBER-1-1.jpg';
import client5 from '../../assets/images/PETRO-1.jpg';
import client6 from '../../assets/images/POCA-1.jpg';
import client7 from '../../assets/images/UNILEVER-1.jpg';
import client8 from '../../assets/images/Bosch_logo-1.jpg';
function CLients() {
    return (
        <div className="clients">
            <div className="clients__title">KHÁCH HÀNG CỦA CHÚNG TÔI</div>
            <div className="clients__list">
                <img className="clients__list-img" src={client1} alt="client 1"></img>
                <img className="clients__list-img" src={client2} alt="client 1"></img>
                <img className="clients__list-img" src={client3} alt="client 1"></img>
                <img className="clients__list-img" src={client4} alt="client 1"></img>
                <img className="clients__list-img" src={client5} alt="client 1"></img>
                <img className="clients__list-img" src={client6} alt="client 1"></img>
                <img className="clients__list-img" src={client7} alt="client 1"></img>
                <img className="clients__list-img" src={client8} alt="client 1"></img>
            </div>
        </div>
    );
}
export default CLients;