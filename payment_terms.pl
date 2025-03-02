use Bookings::Soylent::RoomReservation;
use  Bookings::Db::RoomReservation::PaymentTerms;
use Bookings::Platform::Client::AccResReadApi qw(get_accres_data);
use Bookings::Platform::Client::AccResReadApi::Constants qw( :Fields );
use Data::Dump 'pp';
use feature 'say';

sub payment_terms{
    my $rres_id = shift;
    say("RRES_ID: ", $rres_id);
   my $pt_id;
   my $dt_id;

    say("OLD INIT ");
    say("----------------");
            $terms = Bookings::Db::RoomReservation::PaymentTerms->retrieve(
            roomreservation_id => $rres_id,
        );
    say("OLD PAYTERMS_ID: ", $terms->paymentterms_id);
    say("OLD DEPOSIT_ID: ", $terms->depositterms_id);
    say("OLD NO_SHOW_TERMS_ID: ", $terms->noshow_id);
    say("OLD PAYMENT_COLLECTOR_CODE: ", $terms->payment_collector_code);
    say("OLD PAYMENT_TYPE_ID: ", $terms->pt_type_id);
    say("----------------");
    say("NEW API ");
    say("----------------");
    $result = get_accres_data(
        { roomreservation_ids => [$rres_id] },
        { fields => [ PAYMENT_TERMS_ID,
        DEPOSIT_TERMS_ID, 
        NO_SHOW_TERMS_ID, 
        PAYMENT_COLLECTOR_CODE, 
        PAYMENT_TYPE_ID], migration_name => 'payment_terms'} 
    )->[0] // {};
        
        say("NEW PAYTERMS_ID: ", $result->{+PAYMENT_TERMS_ID});
        say("NEW DEPOSIT_ID: ", $result->{+DEPOSIT_TERMS_ID});
        say("NEW NO_SHOW_TERMS_ID: ", $result->{+NO_SHOW_TERMS_ID});
        say("NEW PAYMENT_COLLECTOR_CODE: ", $result->{+PAYMENT_COLLECTOR_CODE});
        say("NEW PAYMENT_TYPE_ID: ", $result->{+PAYMENT_TYPE_ID});
    
    say("----------------");
}


payment_terms(5316255580);
1;
payment_terms(5379651202);
1;